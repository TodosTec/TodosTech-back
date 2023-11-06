package com.example.apicadastrotodostec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableJpaRepositories(basePackages = "com.example.apicadastrotodostec.Repository")
@EnableMongoRepositories(basePackages = "com.example.apicadastrotodostec.Repository")
public class ApiCadastroTodosTecApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiCadastroTodosTecApplication.class, args);
    }

}
