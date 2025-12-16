package com.tastytown.backend.config;

import com.tastytown.backend.constants.Role;
import com.tastytown.backend.dto.RegisterRequestDTO;
import com.tastytown.backend.model.UserEntity;
import com.tastytown.backend.repository.UserRepository;
import com.tastytown.backend.service.IAuthService;
import com.tastytown.backend.service.IFileService;
import com.tastytown.backend.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Slf4j
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@RequiredArgsConstructor
public class AppConfig {
    private final IFileService fileService;
    private final UserRepository userRepository;
    private final IUserService userService;
    private final PasswordEncoder passwordEncoder;

    @Value("${DEFAULT.ADMIN.EMAIL}")
    private String DEFAULT_ADMIN_EMAIL;

    @Value("${DEFAULT.ADMIN.PASS}")
    private String DEFAULT_ADMIN_PASSWORD;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
//            Create folder to store food images
            fileService.createImagesFolder();

//            Register a intial admin if not exist
            Optional<UserEntity> userOpt = userService.getUserByEmail(DEFAULT_ADMIN_EMAIL);
//            if default admin already exists, do nothing othwerwise create a default ADMIN

            if(!userOpt.isPresent()) {
                UserEntity defaultAdmin = new UserEntity();
                defaultAdmin.setUsername("Super Admin");
                defaultAdmin.setUserEmail(DEFAULT_ADMIN_EMAIL);
                defaultAdmin.setUserPassword(passwordEncoder.encode(DEFAULT_ADMIN_PASSWORD));
                defaultAdmin.setRole(Role.ROLE_ADMIN);

                userRepository.save(defaultAdmin);
                log.info("default admin created");
            } else {
                log.info("default admin already exists");
            }
































            
        };
    }
}
