package com.example.retrytest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootTest
class RetryListenerTest {

	@Autowired
	private MainService mainService;

	@Test
	void retryableShouldWork() {
		mainService.tryRetryable();
	}

}
