package com.julioluis.easyschool.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.csrf().ignoringRequestMatchers("/contact")
                        .and().authorizeHttpRequests()
                        .requestMatchers("/dashboard").authenticated()
                        .requestMatchers("","/","/home").permitAll()
                        .requestMatchers("/courses").permitAll()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/holidays/**").permitAll()
                        .requestMatchers("/assets/**").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .and().formLogin().loginPage("/login")
                        .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                        .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()

                .and().httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails user= User.withDefaultPasswordEncoder()
                .username("user")
                .password("12345")
                .roles("USER")
                .build();

        UserDetails admin= User.withDefaultPasswordEncoder()
                .username("admin")
                .password("12345")
                .roles("USER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user,admin);
    }
}
