package com.recommendation.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_activities")
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String action;
    private LocalDateTime timestamp;

    public UserActivity() {}

    public UserActivity(User user, String action, LocalDateTime timestamp) {
        this.user = user;
        this.action = action;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "UserActivity{" +
                "id=" + id +
                ", user=" + (user != null ? user.getUsername() : "null") +
                ", action='" + action + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
