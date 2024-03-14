package com.example.urlshortner.service;

import com.example.urlshortner.model.domain.Url;
import com.example.urlshortner.model.dto.UrlRequest;

import java.util.Optional;

public interface URLShortnerService {
    Optional<Url> urlShortner(UrlRequest urlRequest);
}
