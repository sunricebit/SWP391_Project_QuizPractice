package com.example.quizv8.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Quiz_User")

public class QuizUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "_email")

    private String email;
    @Column(name = "_password")

    private String password;

    @Column(name = "_role")
    private String role;


    @OneToMany(mappedBy = "user")
    private List<QuizList> quiz;
    public QuizUser() {
    }

    public QuizUser(long id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public List<QuizList> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<QuizList> quiz) {
        this.quiz = quiz;
    }
    //
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
