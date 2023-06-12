package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration 
public class ApiSecurity extends WebSecurityConfigurerAdapter {

    // Secure the endpoins very basc uri based we can add more security
    @Override
    protected void configure(HttpSecurity http) throws Exception {

      
        http.authorizeRequests()
                .antMatchers("/**","/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**")
                .permitAll();
    }

}