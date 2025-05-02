package com.rectivespring.movie_service.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Review {
    private String reviewId;
    @NotNull(message = "rating.movieInfoId: must be preset")
    private Long movieInfoId;

    private String comment;
    @Min(value = 0L, message = "rating.negative : non negative needed")
    private Double rating;
}
