package com.awsprojrct.pragason;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class AwsProjectPragasonBackendApiApplication  {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AwsProjectPragasonBackendApiApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
        };
    }
//    java -jar aws-project-pragason-backend-api-0.0.1-SNAPSHOT.jar
}