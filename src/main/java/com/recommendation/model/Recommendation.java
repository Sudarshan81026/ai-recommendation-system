package com.recommendation.model;

import javax.persistence.*;

@Entity
@Table(name = "recommendations")
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Double score;

    public Recommendation() {}

    public Recommendation(User user, Product product, Double score) {
        this.user = user;
        this.product = product;
        this.score = score;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    @Override
    public String toString() {
        return "Recommendation{" +
                "id=" + id +
                ", user=" + (user != null ? user.getUsername() : "null") +
                ", product=" + (product != null ? product.getName() : "null") +
                ", score=" + score +
                '}';
    }
}
