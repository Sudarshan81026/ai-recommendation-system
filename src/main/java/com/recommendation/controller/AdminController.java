package com.recommendation.controller;

import com.recommendation.model.User;
import com.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    // ADMIN DASHBOARD (shows list of all users)
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/dashboard";
    }

    // ADD USER FORM (HTML)
    @GetMapping("/user/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/add_user";
    }

    // ADD USER (POST)
    @PostMapping("/user/add")
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user); // Hash password in service!
        return "redirect:/admin/dashboard";
    }

    // EDIT USER FORM
    @GetMapping("/user/edit/{id}")
    public String showEditUserForm(@PathVariable Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/edit_user";
    }

    // EDIT USER (POST)
    @PostMapping("/user/edit")
    public String editUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/admin/dashboard";
    }

    // SINGLE USER DELETE
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/admin/dashboard";
    }

    // BULK DELETE
    @PostMapping("/user/bulkDelete")
    public String bulkDeleteUsers(@RequestParam("userIds") List<Integer> userIds) {
        userService.deleteUsers(userIds);
        return "redirect:/admin/dashboard";
    }

    // VIEW USER DETAILS
    @GetMapping("/user/view/{id}")
    public String viewUser(@PathVariable Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        // Add: ratings, recommendations, activities, etc if needed
        return "admin/view_user";
    }
}
