package com.example.spring_project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder){
        String encodedPassword = passwordEncoder.encode("1234");
        System.out.println(encodedPassword);
        return new InMemoryUserDetailsManager(
                User.withUsername("user1").password(encodedPassword).roles("USER").build(),
                User.withUsername("user2").password(encodedPassword).roles("USER").build(),
                User.withUsername("admin").password(encodedPassword).roles("USER","ADMIN").build()
        );
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .formLogin(ar->ar.loginPage("/login").permitAll()) //or formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(ar->ar.requestMatchers("/webjars/** ","/h2-console/**").permitAll())
                .authorizeHttpRequests(ar->ar.requestMatchers("/patients"). hasRole("USER"))
                .authorizeHttpRequests(ar->ar.requestMatchers("/delete").hasRole("ADMIN"))
                .authorizeHttpRequests(ar->ar.requestMatchers("/formPatient").hasRole("ADMIN"))
                .authorizeHttpRequests(ar->ar.requestMatchers("/editPatient").hasRole("ADMIN"))
                .authorizeHttpRequests(ar->ar.requestMatchers("/savePatientPatient").hasRole("ADMIN"))
                .exceptionHandling(ar->ar.accessDeniedPage("/notAuthorized"))
                .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
                .build();
    }
}

//this code was used with old version of spring boot
/*
public class SecurityConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("user1").password(passwordEncoder.encode("1234")).roles("USER").build(),
                User.withUsername("user2").password(passwordEncoder.encode("1234")).roles("USER").build(),
                User.withUsername("admin").password(passwordEncoder.encode("1234")).roles("USER", "ADMIN") .build()

        );

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin().loginPage("/login").permitAll();
        httpSecurity.authorizeHttpRequests().requestMatchers("/webjars/** ","/h2-console/**").permitAll();
        httpSecurity.authorizeHttpRequests().requestMatchers("/patients"). hasRole("USER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/delete").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/formPatient").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/editPatient").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers("/savePatientPatient").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
        httpSecurity.exceptionHandling().accessDeniedPage("/notAuthorized");
        return httpSecurity.build();
        }
}
*/