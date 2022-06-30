package com.example.retrytest;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.listener.RetryListenerSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SubService {

    private int counter = 0;

    @Retryable(value = RuntimeException.class, listeners = {"uploadRetryListener"})
    public void doSomethingThatMightFail() {
        counter++;
        if (counter < 3) {
            System.out.println("Do a retry");
            throw new RuntimeException("Do a retry");
        }
        System.out.println("Made it through");
    }


    /**
     * Breaks Retryable. If moved to a different class it works, if static it works.
     */
    @Component("uploadRetryListener")
    public class UploadRetryListener extends RetryListenerSupport {
        @Override
        public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
            System.out.println("open");
            return true;
        }

        @Override
        public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
            System.out.println("onError");
            super.onError(context, callback, throwable);
        }

        @Override
        public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
            System.out.println("close");
        }
    }
}
