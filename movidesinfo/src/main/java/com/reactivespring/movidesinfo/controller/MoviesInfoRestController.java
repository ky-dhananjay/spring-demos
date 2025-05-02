package com.reactivespring.movidesinfo.controller;

import com.reactivespring.movidesinfo.domain.MovieInfo;
import com.reactivespring.movidesinfo.service.MoviesInfoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/v1")
@Slf4j
public class MoviesInfoRestController {

    private MoviesInfoService moviesInfoService;

    public MoviesInfoRestController(MoviesInfoService moviesInfoService) {
        this.moviesInfoService = moviesInfoService;
    }

    @GetMapping("/flux")
    public Flux<Integer> getFlux(){
        return Flux.just(1,2,3).log();
    }
    @GetMapping("/mono")
    public Mono<Integer> getMono(){
        return Mono.just(1).log();
    }

    @GetMapping("/stream")
    public Flux<Long> getStream(){
        return Flux.interval(Duration.ofSeconds(1)).log();
    }

    @PostMapping("/movieinfos")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MovieInfo> addMovieInfo(@RequestBody @Valid MovieInfo movieInfo){
        return moviesInfoService.addMovieInfo(movieInfo);
    }
    @GetMapping("/movieinfos")
    public Flux<MovieInfo> getAllMovieInfo(@RequestParam(name = "year", value = "year", required = false) Integer year){
        log.info("Year is: {}", year);
        if(year != null){
            return moviesInfoService.findMovieInfoByYear(year);
        }
        return moviesInfoService.getAllMovieInfos();
    }
    @GetMapping("/movieinfos/{movieId}")
    public Mono<ResponseEntity<MovieInfo>> findMovieInfoById(@PathVariable(name = "movieId") String movieInfoId){
        return moviesInfoService.findMovieInfoById(movieInfoId)
            .map(movieInfo -> ResponseEntity.ok()
                .body(movieInfo))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()))
            .log();
    }

    @PutMapping("/movieinfos/{id}")
    public Mono<MovieInfo> updateMovieInfoById(@PathVariable(name = "movieId") String movieInfoId,
                                               @RequestBody MovieInfo movieInfo){
        return moviesInfoService.updateMovieInfo(movieInfoId, movieInfo);
    }


}
