package com.recibo.recibo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Deshabilitar la protección CSRF
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/", "/logout", "/estilos/**", "/img/**").permitAll()
                    .requestMatchers("/user/**").hasRole("USER") 
                    .anyRequest().authenticated()
            )
            .formLogin(formLogin -> 
                formLogin
                    .loginPage("/")
                    .defaultSuccessUrl("/dashboard", true)
                    .permitAll()
            )
            /*.logout(logout ->
                logout
                    .logoutUrl("/logout") // URL para cerrar sesión
                    .logoutSuccessUrl("/?logout")
                    .permitAll()
            )*/
            .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("maroniinmobiliaria@hotmail.com")
            .password("{noop}2999")
            .roles("USER")
            .build());
        return manager;
    }
}
