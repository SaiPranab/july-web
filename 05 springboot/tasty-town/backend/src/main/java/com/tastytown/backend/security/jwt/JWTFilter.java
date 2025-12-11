package com.tastytown.backend.security.jwt;

import com.tastytown.backend.model.UserEntity;
import com.tastytown.backend.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {
    private final JWTUtils jwtUtils;
    private final UserRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response); // Spring auto handles the unauthorized access
            return;
        }

        String token = authHeader.substring(7);

//            Validate token
        jwtUtils.validateToken(token);

//            Extract User Id from the token
        String userId = jwtUtils.extractUserId(token);

        if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // user obj
            UserEntity user = repository.findById(userId)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            // user authorities
            var authorities = List.of(new SimpleGrantedAuthority(user.getRole().toString()));

            // create authentication token
            var authToken = new UsernamePasswordAuthenticationToken(user, null, authorities);

            // set auth token and userId in the context
            SecurityContextHolder.getContext().setAuthentication(authToken);

//                Send the User Id to controller
            request.setAttribute("user", user);
        }

        filterChain.doFilter(request, response);
    }
}
