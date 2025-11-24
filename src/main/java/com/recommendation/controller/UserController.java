package com.recommendation.controller;

import com.recommendation.model.User;
import com.recommendation.model.Product;
import com.recommendation.service.UserService;
import com.recommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
class UserDashboardControllers {

    @Autowired
    private UserService userService;

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/user/dashboard")
    public String userDashboard(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("error", "User not logged in!");
            return "login";
        }
        User user = userService.getUserByUsername(principal.getName());
        if (user == null) {
            model.addAttribute("error", "User not found!");
            return "login";
        }
        List<Product> recommendations = recommendationService.recommendForUser(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("recommendations", recommendations);
        return "users/dashboard";
    }

    @GetMapping("/user/profile")
    public String profile(Model model, Principal principal) {
        return "users/profile";
    }

    @GetMapping("/user/edit-profile")
    public String editProfile(Model model, Principal principal) {
        return "users/editProfile";
    }

    @GetMapping("/user/activity-history")
    public String activityHistory(Model model, Principal principal) {
        return "users/activityHistory";
    }

    @GetMapping("/user/recommendations")
    public String recommendations(Model model, Principal principal) {
        return "users/recommendations";
    }
}
