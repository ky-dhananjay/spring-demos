package com.example.urlshortner.rest;

import com.example.urlshortner.model.domain.Url;
import com.example.urlshortner.model.dto.UrlRequest;
import com.example.urlshortner.service.URLShortnerService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/url-shortner")
public class URLShortnerRest {
    private final URLShortnerService urlShortnerService;

    public URLShortnerRest(@Autowired URLShortnerService urlShortnerService) {
        this.urlShortnerService = urlShortnerService;
    }

    //1. POST: Shorten Url (Destination Url) → Short Url
    @PostMapping
    public ResponseEntity<?> urlShortner(@RequestBody @NotNull UrlRequest urlRequest){
        Optional<Url> shortenedUrl = urlShortnerService.urlShortner(urlRequest);
        if(shortenedUrl.isEmpty()){
            // throw exception
        }
        return new ResponseEntity<>(shortenedUrl, HttpStatus.OK);

    }

    //2. POST: Update short url (Short Url, Destination Url) → Boolean
    //a. update meaning : new destination link on same short link
    //3. GET: Get Destination Url (Short Url) → Destination Url
    //4. POST: Update Expiry (Short Url, Days to add in expity) →Boolean
}