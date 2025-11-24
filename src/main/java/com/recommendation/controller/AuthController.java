package com.recommendation.controller;

import com.recommendation.model.User;
import com.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "autho/register"; // Match your folder structure!
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String email,
                           @RequestParam String password,
                           Model model) {
        if (userService.getUserByUsername(username) != null) {
            model.addAttribute("error", "Username already exists!");
            return "autho/register"; // Also match here!
        }
        User user = new User(username, password, email, "USER", "");
        userService.saveUser(user);
        return "redirect:/login";
    }
}
