package com.rectivespring.movie_service.client;

import com.rectivespring.movie_service.config.WebClientConfig;
import com.rectivespring.movie_service.domain.MovieInfo;
import com.rectivespring.movie_service.exceptions.MovieInfoServerException;
import com.rectivespring.movie_service.exceptions.MoviesInfoClientException;
import com.rectivespring.movie_service.util.RetryUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Exceptions;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Component
public class MoviesInfoRestClient {

    private WebClient webClient;

    @Value("${restClient.moviesInfoUrl}")
    private String moviesInfoUrl;

    public MoviesInfoRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<MovieInfo> retrieveMovieInfo(String movieInfoId){
        var url = moviesInfoUrl.concat("/{id}");



        return webClient
            .get()
            .uri(url, movieInfoId)
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
                if(clientResponse.statusCode().equals(HttpStatus.NOT_FOUND)){
                    return Mono.error(new MoviesInfoClientException(
                        "movie not available for id: " + movieInfoId,
                        clientResponse.statusCode().value()));
                }

                return clientResponse.bodyToMono(String.class)
                    .flatMap(responseMessage -> Mono.error(new MoviesInfoClientException(
                        responseMessage,
                        clientResponse.statusCode().value())));
            })
            .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> clientResponse.bodyToMono(String.class)
                .flatMap(responseMessage -> Mono.error(new MovieInfoServerException(
                    "Movies info server error: " + responseMessage))))
            .bodyToMono(MovieInfo.class)
            .retryWhen(RetryUtil.retrySpec())
            .log();
    }

}
