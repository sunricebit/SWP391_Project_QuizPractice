package com.example.quizv8.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LeaderBoard")
public class LeaderBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "_userId")
    private QuizUser examUser;
    @ManyToOne
    @JoinColumn(name = "_quizId")
    private QuizList quizPractice;
    @Column(name = "_date")
    private LocalDateTime date;
    @Column(name = "_percentage")
    private float percentage;
    @Column(name = "_totalQuestion")
    private long totalQuestion;

    public LeaderBoard() {
    }

    public LeaderBoard(QuizUser examUser, QuizList quizPractice, float percentage, long totalQuestion, LocalDateTime date) {
        this.examUser = examUser;
        this.quizPractice = quizPractice;
        this.date = date;
        this.percentage = percentage;
        this.totalQuestion = totalQuestion;
    }

    public LeaderBoard(long id, QuizUser examUser, QuizList quizPractice,  float percentage, long totalQuestion, LocalDateTime date) {
        this.id = id;
        this.examUser = examUser;
        this.quizPractice = quizPractice;
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

    public QuizList getQuizPractice() {
        return quizPractice;
    }

    public void setQuizPractice(QuizList quizPractice) {
        this.quizPractice = quizPractice;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public long getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(long totalQuestion) {
        this.totalQuestion = totalQuestion;
    }
}