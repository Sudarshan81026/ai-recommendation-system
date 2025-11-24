package com.recommendation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "autho/login";
    }

    // Duplicate mapping REMOVED:
    // @GetMapping("/register")
    // public String registerPage() {
    //     return "autho/register";
    // }

    // Uncomment and adjust this if you have a user dashboard page:
    // @GetMapping("/user/dashboard")
    // public String userDashboard() {
    //     return "users/dashboard"; // folder ka plural 'users' hai!
    // }
}
