package com.recommendation.controller;

import com.recommendation.model.Rating;
import com.recommendation.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public Rating addRating(@RequestBody Rating rating) {
        return ratingService.saveRating(rating);
    }

    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }
}
