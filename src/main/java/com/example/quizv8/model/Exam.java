package com.example.quizv8.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "_userId")
    private QuizUser examUser;
    @Column(name = "_quizName")
    private String quizName;
    @Column(name = "_date")
    private LocalDateTime date;
    @Column(name = "_percentage")
    private String percentage;
    @Column(name = "_totalQuestion")
    private long totalQuestion;

    public Exam() {
    }

    public Exam(QuizUser examUser, String quizName, String percentage, long totalQuestion, LocalDateTime date) {
        this.examUser = examUser;
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

    public QuizUser getExamUser() {
        return examUser;
    }

    public void setExamUser(QuizUser examUser) {
        this.examUser = examUser;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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