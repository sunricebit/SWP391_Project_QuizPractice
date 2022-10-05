package com.example.quizv8.model;

import javax.persistence.*;

@Entity
@Table(name = "Quiz_User")

public class QuizUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "_email", nullable = false)

    private String email;
    @Column(name = "_password", nullable = false)

    private String password;

    @Column(name = "_role",  nullable = false)

    private String role;

    public QuizUser() {
    }

    public QuizUser(long id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
