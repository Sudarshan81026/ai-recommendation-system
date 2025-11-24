package com.recommendation.service;

import com.recommendation.model.Product;
import com.recommendation.model.User;
import com.recommendation.repository.ProductRepository;
import com.recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Product> recommendForUser(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null || user.getPreferences() == null) {
            return List.of();
        }
        String pref = user.getPreferences().toLowerCase();
        return productRepository.findAll()
                .stream()
                .filter(p -> p.getName().toLowerCase().contains(pref)
                        || (p.getCategory() != null
                        && p.getCategory().getName().toLowerCase().contains(pref)))
                .collect(Collectors.toList());
    }
}
