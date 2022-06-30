package com.example.retrytest;

import org.springframework.stereotype.Service;

@Service
public class MainService {

    private SubService subService;

    public MainService(SubService subService) {
        this.subService = subService;
    }

    public void tryRetryable() {
        subService.doSomethingThatMightFail();
    }

}
