package com.reactivespring.movidesinfo.controller;

import com.reactivespring.movidesinfo.domain.MovieInfo;
import com.reactivespring.movidesinfo.repository.MovieInfoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

//@WebFluxTest
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class MoviesInfoRestControllerIntegrationTest {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    MovieInfoRepository movieInfoRepository;

    private static final String MOVIES_INFO_URL = "/v1/movieinfos";

    @BeforeEach
    void setUp() {

        var moviesInfo = List.of(
            new MovieInfo(null,"B B", 2005, List.of("A", "B"), LocalDate.parse("2005-06-15")),
            new MovieInfo(null,"C D", 2005, List.of("C", "D"), LocalDate.parse("2005-06-15")),
            new MovieInfo("ef","E F", 2005, List.of("E", "F"), LocalDate.parse("2005-06-15")),
            new MovieInfo(null,"G H", 2005, List.of("G", "H"), LocalDate.parse("2005-06-15"))
        );

        movieInfoRepository.saveAll(moviesInfo)
            .blockLast();
    }

    @AfterEach
    void tearDown() {
        movieInfoRepository.deleteAll().block();

    }

    @Test
    void addMovieInfo() {
        MovieInfo movieInfo =
            new MovieInfo(null,"Ramayana", 2005, List.of("A", "B"), LocalDate.parse("2005-06-15"));

        webTestClient
            .post()
            .uri(MOVIES_INFO_URL)
            .bodyValue(movieInfo)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBody(MovieInfo.class)
            .consumeWith(movieInfoEntityExchangeResult -> {
                var savedMovie = movieInfoEntityExchangeResult.getResponseBody();
                assert Objects.requireNonNull(savedMovie).getMovieInfoId() != null;

            });

    }

    @Test
    void getAllMovieInfo() {
        /**
         * whenever Flux is returned from the endpoint
         * expect a bodylist
         */
        webTestClient
            .get()
            .uri(MOVIES_INFO_URL)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBodyList(MovieInfo.class)
            .hasSize(4);
    }
    @Test
    void getAllMovieInfoByYear() {
        var uri = UriComponentsBuilder
            .fromUriString(MOVIES_INFO_URL)
                .queryParam("year", 2005)
                    .buildAndExpand()
                        .toUri();
        /**
         * whenever Flux is returned from the endpoint
         * expect a bodylist
         */
        webTestClient
            .get()
            .uri(uri)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBodyList(MovieInfo.class)
            .hasSize(4);
    }

    @Test
    void findMovieInfoById() {
        String movieInfoId = "ef";
        webTestClient
            .get()
            .uri(MOVIES_INFO_URL + "/{movieId}", movieInfoId)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBody(MovieInfo.class)
            .consumeWith(movieInfoEntityExchangeResult -> {
                var savedMovie = movieInfoEntityExchangeResult.getResponseBody();
                assert Objects.equals(Objects.requireNonNull(savedMovie).getMovieInfoId(), "ef");
            });
    }
    @Test
    void findMovieInfoById_approach2() {
        String movieInfoId = "ef";
        webTestClient
            .get()
            .uri(MOVIES_INFO_URL + "{movieId}", movieInfoId)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBody()
            .jsonPath("$.name").isEqualTo("E F");
    }
}