package com.example.patentproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableTransactionManagement
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
@Configuration
@EnableWebMvc
@MapperScan("com.example.patentproject.mapper")

public class PatentProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatentProjectApplication.class, args);
    }

}
