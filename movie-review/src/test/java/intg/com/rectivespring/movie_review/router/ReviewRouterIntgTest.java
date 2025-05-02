package com.rectivespring.movie_review.router;

import com.rectivespring.movie_review.domain.Review;
import com.rectivespring.movie_review.repository.ReviewReactiveRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class ReviewRouterIntgTest {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    ReviewReactiveRepository reviewReactiveRepository;

    private static final String REVIEW_URL = "/v1/reviews";

    @BeforeEach
    void setUp() {
        var reviewList = List.of(
            new Review(null, 1L, "Awesome movie", 9.0),
            new Review(null, 1L, "Awesome movie", 9.0),
            new Review("abc", 2L, "Rotten movie", 8.0)
            );
        reviewReactiveRepository.saveAll(reviewList)
            .blockLast();
    }

    @AfterEach
    void tearDown() {
        reviewReactiveRepository.deleteAll().block();
    }

    @Test
    void addReview(){
        var review = new Review(null, 1L, "osome movie", 9.0);
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
    void getAllReviews(){
        webTestClient
            .get()
            .uri(REVIEW_URL)
            .exchange()
            .expectStatus()
            .isOk()
            .expectBodyList(Review.class)
            .hasSize(3);
    }
    @Test
    void getReviewsByMovieInfoId(){
        var uri = UriComponentsBuilder
            .fromUriString(REVIEW_URL)
                .queryParam("movieInfoId", 1L)
                    .buildAndExpand()
                        .toUri();
        webTestClient
            .get()
            .uri(uri)
            .exchange()
            .expectStatus()
            .isOk()
            .expectBodyList(Review.class)
            .hasSize(2);
    }
    @Test
    void updateReview(){
        var review = new Review("abc", 1L, "osomeness movie", 9.0);
        webTestClient
            .put()
            .uri(REVIEW_URL+"/{id}", "abc")
            .bodyValue(review)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBody(Review.class)
            .consumeWith(reviewEntityExchangeResult -> {
                var savedReview = reviewEntityExchangeResult.getResponseBody();
                assertNotNull(savedReview);
                assert Objects.equals(savedReview.getReviewId(), "abc");
            });
    }
    @Test
    void deleteReview(){
        var review = new Review("abc", 1L, "osomeness movie", 9.0);
        webTestClient
            .delete()
            .uri(REVIEW_URL+"/{id}", "abc")
            .exchange()
            .expectStatus()
            .isNoContent();
    }
}