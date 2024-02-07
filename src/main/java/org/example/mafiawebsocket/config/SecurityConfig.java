package org.example.mafiawebsocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(authz-> {
                    try {
                        authz.requestMatchers("/api/users/login").permitAll()
                                                             .anyRequest()
                                                             .authenticated().and()
                                        .formLogin()
                                        .defaultSuccessUrl("/").failureUrl("/login").loginPage("/login")
                                        .loginProcessingUrl("/api/users/dologin").and().logout().logoutSuccessUrl("/login")
                                        .deleteCookies("");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                                             .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
