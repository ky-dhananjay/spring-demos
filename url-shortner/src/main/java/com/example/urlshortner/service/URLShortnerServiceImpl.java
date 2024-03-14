package com.example.urlshortner.service;

import com.example.urlshortner.model.domain.Url;
import com.example.urlshortner.model.dto.UrlRequest;
import com.example.urlshortner.repository.URLShortnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class URLShortnerServiceImpl implements URLShortnerService{
    @Autowired
    UrlShortnerLogic urlShortnerLogic;

    @Autowired
    URLShortnerRepo urlShortnerRepo;
    @Override
    public Optional<Url> urlShortner(UrlRequest urlRequest) {
        String shortenedUrl = urlShortnerLogic.urlShortnerLogic(urlRequest.getSourceUrl());
        Url url = new Url.Builder()
            .id(UUID.randomUUID())
            .sourceUrl(urlRequest.getSourceUrl())
            .shortenedUrl(shortenedUrl)
            .createdAt(Instant.now().toEpochMilli())
            .build();
        urlShortnerRepo.save(url);
        return Optional.ofNullable(url);
    }
}
