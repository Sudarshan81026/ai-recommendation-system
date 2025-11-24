package com.recommendation.model;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer value; // e.g., 1-5 stars
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Rating() {}

    public Rating(Integer value, String comment, User user, Product product) {
        this.value = value;
        this.comment = comment;
        this.user = user;
        this.product = product;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getValue() { return value; }
    public void setValue(Integer value) { this.value = value; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", value=" + value +
                ", comment='" + comment + '\'' +
                ", user=" + (user != null ? user.getUsername() : "null") +
                ", product=" + (product != null ? product.getName() : "null") +
                '}';
    }
}
