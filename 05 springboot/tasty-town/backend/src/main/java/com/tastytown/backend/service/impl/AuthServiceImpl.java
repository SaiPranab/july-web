package com.tastytown.backend.service.impl;

import com.tastytown.backend.dto.AuthRequestDTO;
import com.tastytown.backend.dto.AuthResponseDTO;
import com.tastytown.backend.model.UserEntity;
import com.tastytown.backend.repository.UserRepository;
import com.tastytown.backend.security.jwt.JWTUtils;
import com.tastytown.backend.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JWTUtils jwtUtils;

    @Override
    public AuthResponseDTO login(AuthRequestDTO dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.userEmail(), dto.userPassword()));

        UserEntity user = userRepository.findByUserEmail(dto.userEmail()).orElseThrow(() ->
                new UsernameNotFoundException("User not found with email"));

        String generatedToken = jwtUtils.generateToken(user.getUserId(), user.getRole());

        return new AuthResponseDTO(generatedToken);
    }
}
