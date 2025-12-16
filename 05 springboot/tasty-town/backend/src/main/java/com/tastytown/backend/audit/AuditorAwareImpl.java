package com.tastytown.backend.audit;

import com.tastytown.backend.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Slf4j
@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    @Value("${DEFAULT.ADMIN.EMAIL}")
    private String DEFAULT_ADMIN_EMAIL;

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || !authentication.isAuthenticated()) {
            return Optional.of(DEFAULT_ADMIN_EMAIL);
        }

        Object principal = authentication.getPrincipal();
        if(principal instanceof UserEntity user) { // JDK 17
            log.info("Currently logged in user {}", user);
            return Optional.of(user.getUserEmail());
        }

        return Optional.ofNullable(authentication.getName());
    }
}


