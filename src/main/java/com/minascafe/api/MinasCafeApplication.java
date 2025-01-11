package com.minascafe.api;
// @author Edson Ferreira Barbosa

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@CrossOrigin
public class MinasCafeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MinasCafeApplication.class, args);
    }
}