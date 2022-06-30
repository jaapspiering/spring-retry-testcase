## Simple Spring Boot test case
for https://github.com/spring-projects/spring-retry/issues/193

### Details
- Has a MainService and SubService
- SubService has a method with @Retryable, which works fine.
- When a RetryListener is defined (public class) within SubService, the retryable functionality breaks.
- When a RetryListener is defined (public static class) within SubService, the retryable functionality works.
- When a RetryListener is defined (public class) elsewhere, the retryable functionality works.
- Regardless of whether the retryListener is referenced.
- Use `RetryListenerTest` to test.