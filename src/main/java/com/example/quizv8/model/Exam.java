package com.example.quizv8.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "_userId")
    private long userId;
    @Column(name = "_quizName")
    private String quizName;
    @Column(name = "_date")
    private LocalDate date;
    @Column(name = "_percentage")
    private String percentage;
    @Column(name = "_totalQuestion")
    private long totalQuestion;

    public Exam() {
    }

    public Exam(long userId, String quizName, String percentage, long totalQuestion,LocalDate date) {
        this.userId = userId;
        this.quizName = quizName;
        this.date = date;
        this.percentage = percentage;
        this.totalQuestion = totalQuestion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public long getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(long totalQuestion) {
        this.totalQuestion = totalQuestion;
    }
}
