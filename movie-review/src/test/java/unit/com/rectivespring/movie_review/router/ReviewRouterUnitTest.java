package com.rectivespring.movie_review.router;

import com.rectivespring.movie_review.domain.Review;
import com.rectivespring.movie_review.exceptionhandler.GlobalErrorHandler;
import com.rectivespring.movie_review.handler.ReviewHandler;
import com.rectivespring.movie_review.repository.ReviewReactiveRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;

@WebFluxTest
@AutoConfigureWebTestClient
@ContextConfiguration(classes = {ReviewRouter.class, ReviewHandler.class, GlobalErrorHandler.class})
class ReviewRouterUnitTest {
    @MockBean
    private ReviewReactiveRepository reviewReactiveRepository;

    @Autowired
    private WebTestClient webTestClient;

    private static final String REVIEW_URL = "/v1/reviews";

    @Test
    void addReview(){
        var review = new Review(null, 1L, "osome movie", 9.0);

        Mockito.when(reviewReactiveRepository.save(isA(Review.class)))
            .thenReturn(Mono.just(
                new Review("cde", 1L, "osome movie", 9.0)
            ));

        webTestClient
            .post()
            .uri(REVIEW_URL)
            .bodyValue(review)
            .exchange()
            .expectStatus()
            .isCreated()
            .expectBody(Review.class)
            .consumeWith(reviewEntityExchangeResult -> {
                var savedReview = reviewEntityExchangeResult.getResponseBody();
                assertNotNull(savedReview);
                assert savedReview.getReviewId() != null;
            });
    }
    @Test
    void addReview_validation(){
        var review = new Review(null, null, "osome movie", -9.0);

        Mockito.when(reviewReactiveRepository.save(isA(Review.class)))
            .thenReturn(Mono.just(
                new Review("cde", 1L, "osome movie", 9.0)
            ));

        webTestClient
            .post()
            .uri(REVIEW_URL)
            .bodyValue(review)
            .exchange()
            .expectStatus()
            .isBadRequest()
            .expectBody(String.class)
            .isEqualTo("rating.movieInfoId: must be preset,rating.negative : non negative needed");
    }
}