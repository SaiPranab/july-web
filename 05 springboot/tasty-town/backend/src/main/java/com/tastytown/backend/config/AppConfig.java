package com.tastytown.backend.config;

import com.tastytown.backend.service.IFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@RequiredArgsConstructor
public class AppConfig {
    private final IFileService fileService;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
                fileService.createImagesFolder();
        };
    }
}
