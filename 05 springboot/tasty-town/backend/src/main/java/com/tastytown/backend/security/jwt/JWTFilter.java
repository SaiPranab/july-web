package com.tastytown.backend.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {
    private final JWTUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        try {
            if(authHeader == null || !authHeader.startsWith("Bearer ")) {
                filterChain.doFilter(request, response); // Spring auto handles the unauthorized access
                return;
            }

            String jwt = authHeader.substring(7);
            String userId = jwtUtils.extractUsername(jwt);

            if(userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // user obj

                // user authorities

                // create authentication token

                // set auth token and userId in the context
            }
        } catch (Exception e) {

        }
    }
}
