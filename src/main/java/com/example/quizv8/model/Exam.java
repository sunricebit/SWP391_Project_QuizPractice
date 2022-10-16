package com.example.quizv8.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "_userId")
    private long userId;
    @Column(name = "_quizName")
    private String quizName;
    @Column(name = "_date")
    private Date date;
    @Column(name = "_percentage")
    private String percentage;
    @Column(name = "_totalQuestion")
    private long totalQuestion;

    public Exam() {
    }

    public Exam(long id, long userId, String quizName, Date date, String percentage, long totalQuestion) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
