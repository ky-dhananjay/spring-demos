package com.example.urlshortner.repository;

import com.example.urlshortner.model.domain.Url;

public interface URLShortnerRepo {
    void save(Url url);
}
