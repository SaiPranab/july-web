package com.example.security_demo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
  private final UserRepository repository;

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) {
    return http
        .csrf(csrf -> csrf.disable())

        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/contact").authenticated()
            .anyRequest().permitAll())

        // .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

        .formLogin(Customizer.withDefaults())
        .logout(Customizer.withDefaults())

        .build();
  }

  @Bean
  UserDetailsService detailsService() {
    // UserDetails user1 = new User("Sai", "1234", List.of());
    // return new InMemoryUserDetailsManager(user1);

    return (email) -> {
      UserEntity entity = repository.findByUserEmail(email)
          .orElseThrow(() -> new UsernameNotFoundException("User not found"));

      return new User(entity.getUserEmail(),
          entity.getUserPassword(),
          List.of());
    };
  }

  @Bean
  PasswordEncoder encoder() {
    // return NoOpPasswordEncoder.getInstance();
    return new BCryptPasswordEncoder();
  }

  @Bean
  AuthenticationManager authenticationManager() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider(detailsService());
    provider.setPasswordEncoder(encoder());
    return new ProviderManager(provider);
  }

  @Bean
  CommandLineRunner commandLineRunner() {
    return args -> {
      Optional<UserEntity> optional = repository.findByUserEmail("s@gmail.com");
      if (optional.isEmpty()) {
        UserEntity entity = new UserEntity();
        entity.setUserEmail("s@gmail.com");
        entity.setUserPassword(encoder().encode("sai"));

        repository.save(entity);
      }
    };
  }
}
