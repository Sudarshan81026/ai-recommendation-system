package com.recommendation.controller;

import com.recommendation.model.Product;
import com.recommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/{userId}")
    public List<Product> recommend(@PathVariable Integer userId) {
        return recommendationService.recommendForUser(userId);
    }
}
