package com.example.ZTP_PROJ3.security;

import com.example.ZTP_PROJ3.beans.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@EnableWebSecurity
@Configuration
public class CustomSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/dashboard").hasAnyRole("USER", "ADMIN")
                .and().httpBasic()
                .and().cors().disable()
                .csrf().disable();
        http.authorizeHttpRequests().antMatchers(HttpMethod.POST, "/dashboard").hasRole("ADMIN")
                .and().httpBasic()
                .and().cors().disable()
                .csrf().disable();
        http.authorizeHttpRequests().antMatchers(HttpMethod.DELETE, "/dashboard/**").hasRole("ADMIN")
                .and().httpBasic()
                .and().cors().disable()
                .csrf().disable();
    }
//        http
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/login").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.POST, "/dashboard").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/dashboard").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/dashboard/**").hasRole("ADMIN")
//                .and().httpBasic()
//                .and().cors().disable()
//                .csrf().disable()
//                .formLogin().successHandler(myAuthenticationSuccessHandler)
//                .failureHandler(myAuthenticationFailureHandler).loginProcessingUrl("/login").loginPage("/index").permitAll()
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index?logout").deleteCookies("remember-me").permitAll()
//                .and()
//                .rememberMe();
//    }


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
