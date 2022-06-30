package com.example.retrytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class RetryListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetryListenerApplication.class, args);
    }

}
