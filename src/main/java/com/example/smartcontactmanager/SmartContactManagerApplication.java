package com.example.smartcontactmanager;  // अपना actual package use करो (log से com.example.smartcontactmanager लग रहा है)

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;  // यह import जरूर add करो!

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.smartcontactmanager.repository")  // यहां अपना repository package का नाम डालो, जैसे com.example.smartcontactmanager.repository
public class SmartContactManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartContactManagerApplication.class, args);
    }
}
