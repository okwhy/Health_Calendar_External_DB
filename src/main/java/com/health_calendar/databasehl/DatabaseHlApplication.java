package com.health_calendar.databasehl;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DatabaseHlApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatabaseHlApplication.class, args);
    }

}
