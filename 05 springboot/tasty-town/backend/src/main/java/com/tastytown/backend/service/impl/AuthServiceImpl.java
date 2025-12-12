package com.tastytown.backend.service.impl;

import com.tastytown.backend.constants.Role;
import com.tastytown.backend.dto.AuthRequestDTO;
import com.tastytown.backend.dto.AuthResponseDTO;
import com.tastytown.backend.dto.RegisterRequestDTO;
import com.tastytown.backend.model.UserEntity;
import com.tastytown.backend.repository.UserRepository;
import com.tastytown.backend.security.jwt.JWTUtils;
import com.tastytown.backend.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
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

    @Override
    public void register(RegisterRequestDTO dto, Role role) {
        if(dto.username() == null || dto.username().isEmpty() || dto.username().isBlank() ||
            dto.userEmail() == null || dto.userEmail().isEmpty() || dto.userEmail().isBlank() ||
                dto.userPassword() == null || dto.userPassword().isEmpty() ||dto.userPassword().isBlank()
        ) {
            throw new RuntimeException("Missing Required Details");
        }

        Optional<UserEntity> existingUserOpt = userRepository.findByUserEmail(dto.userEmail());
        if(!existingUserOpt.isPresent()) {
            UserEntity newUser = UserEntity.builder()
                    .username(dto.username())
                    .userEmail(dto.userEmail())
                    .userPassword(passwordEncoder.encode(dto.userPassword()))
                    .role(role)
                    .build();

            userRepository.save(newUser);
        }

        throw new RuntimeException("Email already exists");
    }


}
