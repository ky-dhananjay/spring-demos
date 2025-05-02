package com.reactivespring.movidesinfo.service;

import com.reactivespring.movidesinfo.domain.MovieInfo;
import com.reactivespring.movidesinfo.repository.MovieInfoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MoviesInfoService {

    private MovieInfoRepository movieInfoRepository;

    public MoviesInfoService(MovieInfoRepository movieInfoRepository) {
        this.movieInfoRepository = movieInfoRepository;
    }

    public Mono<MovieInfo> addMovieInfo(MovieInfo movieInfo) {
        return movieInfoRepository.save(movieInfo);
    }

    public Flux<MovieInfo> getAllMovieInfos() {
        return movieInfoRepository.findAll();
    }

    public Mono<MovieInfo> findMovieInfoById(String movieInfoId) {
        return movieInfoRepository.findById(movieInfoId);
    }

    public Mono<MovieInfo> updateMovieInfo(String movieInfoId, MovieInfo movieInfo) {
        return movieInfoRepository.findById(movieInfoId)
            .flatMap(movieInfo1 -> {
                movieInfo1.setYear(movieInfo.getYear());
                movieInfo1.setName(movieInfo.getName());
                movieInfo1.setRelease_date(movieInfo.getRelease_date());
                movieInfo1.setCast(movieInfo.getCast());
                return movieInfoRepository.save(movieInfo1);
            });
    }

    public Flux<MovieInfo> findMovieInfoByYear(Integer year) {
        return movieInfoRepository.findByYear(year);
    }
}
