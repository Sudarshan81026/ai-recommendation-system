package com.recommendation.config;

import com.recommendation.model.Category;
import com.recommendation.model.Product;
import com.recommendation.model.User;
import com.recommendation.repository.CategoryRepository;
import com.recommendation.repository.ProductRepository;
import com.recommendation.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserRepository userRepo,
                                      CategoryRepository categoryRepo,
                                      ProductRepository productRepo) {
        return args -> {
            // User Alice
            User alice = new User();
            alice.setUsername("alice");
            alice.setPassword("pass123");
            alice.setEmail("alice@example.com");
            alice.setRole("USER");
            alice.setPreferences("electronics");
            userRepo.save(alice);

            // User Bob
            User bob = new User();
            bob.setUsername("bob");
            bob.setPassword("bobpass");
            bob.setEmail("bob@example.com");
            bob.setRole("USER");
            bob.setPreferences("books");
            userRepo.save(bob);

            // Category Electronics
            Category electronics = new Category();
            electronics.setName("Electronics");
            categoryRepo.save(electronics);

            // Category Books
            Category books = new Category();
            books.setName("Books");
            categoryRepo.save(books);

            // Product Smartphone
            Product smartphone = new Product();
            smartphone.setName("Smartphone");
            smartphone.setDescription("Latest model");
            smartphone.setCategory(electronics);
            productRepo.save(smartphone);

            // Product Laptop
            Product laptop = new Product();
            laptop.setName("Laptop");
            laptop.setDescription("Gaming laptop");
            laptop.setCategory(electronics);
            productRepo.save(laptop);

            // Product Novel
            Product novel = new Product();
            novel.setName("Novel");
            novel.setDescription("Bestselling novel");
            novel.setCategory(books);
            productRepo.save(novel);

            // Product Biography
            Product biography = new Product();
            biography.setName("Biography");
            biography.setDescription("Inspiring life story");
            biography.setCategory(books);
            productRepo.save(biography);
        };
    }
}