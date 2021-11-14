package com.mycompany.myapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by Amir on 4/12/2021.
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//or we can use this in application.peroperties
//spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration
public class test01 extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(test01.class, args);
    }
    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application;
    }*/
}
