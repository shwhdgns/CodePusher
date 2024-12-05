package com.sds.codepusher.config;

import com.sds.codepusher.login.filter.JwtAuthenticationFilter;
import com.sds.codepusher.login.jwt.service.JwtService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtService jwtService;

    public SecurityConfig(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Bean
    @ConditionalOnProperty(name = "auth.form-login", havingValue = "true", matchIfMissing = false)
    public SecurityFilterChain formLoginSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                );
        return http.build();
    }

    @Bean
    @ConditionalOnProperty(name = "auth.oauth2-login", havingValue = "true", matchIfMissing = false)
    public SecurityFilterChain oauth2LoginSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/login", "/error").permitAll()
                        .anyRequest().authenticated()
                )
                // OAuth2 로그인 설정
                .oauth2Login(oauth2 -> oauth2
                        // 로그인 성공 핸들러
                        .successHandler(authenticationSuccessHandler())
                        // 로그인 실패 URL
                        .failureUrl("/error")
                );
        return http.build();
    }

    @Bean
    @ConditionalOnProperty(name = "auth.jwt-login", havingValue = "true", matchIfMissing = false)
    public SecurityFilterChain jwtLoginSecurityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtFilter) throws Exception {
        http
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (request, response, authentication) -> {
            // OAuth2User로부터 JWT를 생성하여 응답 헤더에 추가
            String token = jwtService.generateJwtToken((OAuth2User) authentication.getPrincipal());
            response.addHeader("Authorization", "Bearer " + token);
            response.sendRedirect("/github/github-login-success");
        };
    }
}