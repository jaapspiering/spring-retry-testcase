package com.example.retrytest;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UnrelatedService {

}
