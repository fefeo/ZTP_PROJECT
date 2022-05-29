package com.example.ZTP_PROJ6.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
@Configuration
public class CustomSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
//    @Autowired
//    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
//    @Autowired
//    MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/dashboard/all").permitAll()
                .and().httpBasic()
                .and().cors().disable()
                .csrf().disable();
        http.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/dashboard/user").hasAnyRole("USER", "ADMIN")
                .and().httpBasic()
                .and().cors().disable()
                .csrf().disable();
        http.authorizeHttpRequests().antMatchers(HttpMethod.POST, "/dashboard").hasAnyRole("ADMIN", "USER")
                .and().httpBasic()
                .and().cors().disable()
                .csrf().disable();
        http.authorizeHttpRequests().antMatchers(HttpMethod.DELETE, "/dashboard/admin/**").hasRole("ADMIN")
                .and().httpBasic()
                .and().cors().disable()
                .csrf().disable();
        http.authorizeHttpRequests().antMatchers(HttpMethod.DELETE, "/dashboard/user/**").hasAnyRole("ADMIN", "USER")
                .and().httpBasic()
                .and().cors().disable()
                .csrf().disable();
        http.authorizeHttpRequests().antMatchers(HttpMethod.DELETE, "/user_dashboard/**").hasRole("ADMIN")
                .and().httpBasic()
                .and().cors().disable()
                .csrf().disable();
        http.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/user_dashboard").hasRole("ADMIN")
                .and().httpBasic()
                .and().cors().disable()
                .csrf().disable();
        http.authorizeHttpRequests().antMatchers(HttpMethod.POST, "/user_dashboard").hasAnyRole("ADMIN", "USER")
                .and().httpBasic()
                .and().cors().disable()
                .csrf().disable();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
