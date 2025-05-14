package com.sa.spring_tuto_web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.sa.spring_tuto_web.model.Account;
import com.sa.spring_tuto_web.service.AccountService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers( "/api/admins/**").hasRole("ADMIN")
                        .requestMatchers("api/accounts/**").permitAll()
                        .requestMatchers("/api/students/**", "/api/teachers/**", "/api/modules/**").hasAnyRole("ADMIN", "TEACHER")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()) // modern way to enable HTTP Basic Auth
                .build();
    }


    @Bean
    public UserDetailsService userDetailsService(AccountService accountService) {
        return username -> {
            Account account = accountService.getAccountByUsername(username);
            if (account == null) {
                throw new UsernameNotFoundException("User not found: " + username);
            }
            return User
                    .withUsername(account.getUsername())
                    .password(account.getPassword())
                    .roles(account.getRole())
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}