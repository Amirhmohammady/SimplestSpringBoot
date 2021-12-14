package com.mycompany.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Amir on 11/13/2021.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("user")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .antMatchers("/", "/**").access("hasRole('USER') or hasRole('ADMIN')")//hasRole("USER")
                .and().logout().logoutUrl("/logout").permitAll().logoutSuccessUrl("/").and()
                .formLogin().failureUrl("/login_fail")
                .failureHandler(new AuthenticationFailureHandler() {
                    public static final String LAST_USERNAME_KEY = "LAST_USERNAME";

                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                                        AuthenticationException exception) throws IOException, ServletException {
                        //super.onAuthenticationFailure(request, response, exception);
                        String lastphonenumber = request.getParameter("username");
                        System.out.println("+++++++++++++++++++++++++++++++++" + lastphonenumber);
                        System.out.println("=================================" + exception);
                        HttpSession session = request.getSession(false);
                        if (session != null) request.getSession().setAttribute(LAST_USERNAME_KEY, lastphonenumber);
                        request.getRequestDispatcher("login_fail").forward(request, response);
                    }
                }).loginPage("/login").permitAll().and().rememberMe().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        //without this logout not working
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
