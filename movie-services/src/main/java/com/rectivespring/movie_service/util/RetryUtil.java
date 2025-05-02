package com.rectivespring.movie_service.util;

import com.rectivespring.movie_service.exceptions.MovieInfoServerException;
import com.rectivespring.movie_service.exceptions.ReviewServerException;
import reactor.core.Exceptions;
import reactor.util.retry.Retry;

import java.time.Duration;

public class RetryUtil {
    public static Retry retrySpec(){
        return Retry.fixedDelay(3, Duration.ofSeconds(1))
            .filter(throwable -> throwable instanceof MovieInfoServerException ||
                throwable instanceof ReviewServerException)
            .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) -> Exceptions.propagate(retrySignal.failure()));

    }
}
