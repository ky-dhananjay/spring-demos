package com.reactivespring.moviesinfo.controller;

import com.reactivespring.movidesinfo.controller.MoviesInfoRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.webservices.client.WebServiceClientTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


@WebFluxTest(controllers = MoviesInfoRestController.class)
@AutoConfigureWebTestClient
class MoviesInfoRestControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void getFlux() {
        webTestClient
            .get()
            .uri("/flux")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBodyList(Integer.class)
            .hasSize(3);
    }
    @Test
    void getFlux_approach2() {
        var flux = webTestClient
            .get()
            .uri("/flux")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .returnResult(Integer.class)
            .getResponseBody();

        StepVerifier.create(flux)
            .expectNext(1,2,3)
            .verifyComplete();
    }
    @Test
    void getFlux_approach3() {
        webTestClient
            .get()
            .uri("/flux")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBodyList(Integer.class)
            .consumeWith(listEntityExchangeResult -> {
                var responsebody = listEntityExchangeResult.getResponseBody();
                assert Objects.requireNonNull(responsebody).size() == 3;
            });

    }
    @Test
    void getMono_approach3() {
        webTestClient
            .get()
            .uri("/mono")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBody(Integer.class)
            .consumeWith(intEntityExchangeResult -> {
                var responsebody = intEntityExchangeResult.getResponseBody();
                assertEquals(1,responsebody);
            });
    }

    @Test
    void getStream_approach2() {
        var flux = webTestClient
            .get()
            .uri("/stream")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .returnResult(Long.class)
            .getResponseBody();

        StepVerifier.create(flux)
            .expectNext(0L,1L,2L)
            .thenCancel()
            .verify();
    }
}