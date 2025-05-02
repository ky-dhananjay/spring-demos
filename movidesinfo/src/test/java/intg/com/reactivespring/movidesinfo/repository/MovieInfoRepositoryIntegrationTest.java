package com.reactivespring.movidesinfo.repository;

import com.reactivespring.movidesinfo.domain.MovieInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ActiveProfiles("test")
class MovieInfoRepositoryIntegrationTest {
    @Autowired
    MovieInfoRepository movieInfoRepository;

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
    void findAll(){
        var moviesInfoFlux = movieInfoRepository.findAll().log();
        StepVerifier.create(moviesInfoFlux)
            .expectNextCount(4)
            .verifyComplete();
    }
    @Test
    void findById(){
        var moviesInfoFlux = movieInfoRepository.findById("ef").log();
        StepVerifier.create(moviesInfoFlux)
            .assertNext(movieInfo -> {
                assertEquals("E F", movieInfo.getName());
            });
    }
    @Test
    void saveMovieInfo(){
        var movieInfo = new MovieInfo(null,"find star", 2005, List.of("A", "B"), LocalDate.parse("2005-06-15"));
        var moviesInfoFlux = movieInfoRepository.save(movieInfo).log();
        StepVerifier.create(moviesInfoFlux)
            .assertNext(movieInfo1 -> {
                assertEquals("find star", movieInfo1.getName());
            });
    }
    @Test
    void updateMovieInfo(){
        //var movieInfo = new MovieInfo(null,"find star", 2005, List.of("A", "B"), LocalDate.parse("2005-06-15"));
        var moviesInfo = movieInfoRepository.findById("ef").block();

        assert moviesInfo != null;
        moviesInfo.setYear(2021);

        var moviesInfoMono = movieInfoRepository.save(moviesInfo).log();

        StepVerifier.create(moviesInfoMono)
            .assertNext(movieInfo1 -> {
                assertEquals(2021, movieInfo1.getYear());
            });
    }
    @Test
    void deleteMovieInfo(){
        //var movieInfo = new MovieInfo(null,"find star", 2005, List.of("A", "B"), LocalDate.parse("2005-06-15"));
        movieInfoRepository.deleteById("ef").block();

        var moviesInfo = movieInfoRepository.findAll().log();

        StepVerifier.create(moviesInfo)
            .expectNextCount(2)
            .verifyComplete();
    }
    @Test
    void findByYear(){
        var moviesInfoFlux = movieInfoRepository.findByYear(2005).log();
        StepVerifier.create(moviesInfoFlux)
            .assertNext(movieInfo -> {
                assertEquals(2005, movieInfo.getYear());
            });
    }
}