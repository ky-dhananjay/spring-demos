package com.example.urlshortner.service;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class Base62Shortner implements UrlShortnerLogic{
    @Override
    public String urlShortnerLogic(String rawUrl) {
        return Base64.getEncoder().encodeToString(rawUrl.getBytes(StandardCharsets.UTF_8));
    }
}
