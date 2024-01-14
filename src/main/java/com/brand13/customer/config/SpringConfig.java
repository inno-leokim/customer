package com.brand13.customer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        return  http.authorizeHttpRequests(auth -> 
                    auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().permitAll()
                )
                .csrf(csrf -> 
                    csrf.ignoringRequestMatchers("/h2-console/**")
                )
                .headers(header -> 
                    // header.frameOptions(frameOption -> frameOption.disable())
                    header.frameOptions(frameOption -> frameOption.sameOrigin())
                )      
                .formLogin(form -> 
                    form
                        .permitAll()
                        .defaultSuccessUrl("/", true)    
                ).build();
    }

    @Configuration
    static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Autowired
        UserDetailsService userDetailsService;

        @Bean
        PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService)
                    .passwordEncoder(passwordEncoder());
        }

    }
}
