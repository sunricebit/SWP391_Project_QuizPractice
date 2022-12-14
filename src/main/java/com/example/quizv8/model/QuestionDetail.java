package com.example.quizv8.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Question_Details")
public class QuestionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_questionNo")
    private long questionNo;
    @ManyToOne
    @JoinColumn(name = "id")
    private QuizList quizList;
    @Column(name = "_question")
    private String question;

    @Column(name="_answerA")
    private String answerA;

    @Column(name="_answerB")
    private String answerB;

    @Column(name="_answerC")
    private String answerC;

    @Column(name="_answerD")
    private String answerD;

    @Column(name="_correctAnswer")
    private String correctAnswer;
    public QuestionDetail() {
    }
    public QuestionDetail(long questionNo, QuizList quizList, String question, String answerA, String answerB, String answerC, String answerD, String correctAnswer) {

        this.questionNo = questionNo;
        this.quizList = quizList;
        this.question = question;
        this.answerA = answerA;
        this.correctAnswer = correctAnswer;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;

    }

    public QuestionDetail(QuizList quizList, String question, String answerA, String answerB, String answerC, String answerD, String correctAnswer) {
        this.quizList = quizList;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
    }

    public long getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(long questionNo) {
        this.questionNo = questionNo;
    }

    public QuizList getQuizList() {
        return quizList;
    }

    public void setQuizList(QuizList quizList) {
        this.quizList = quizList;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    @Override
    public String toString() {
        return "QuestionDetail{" +
                "questionNo=" + questionNo +
                ", quizList=" + quizList +
                ", question='" + question + '\'' +
                ", answerA='" + answerA + '\'' +
                ", answerB='" + answerB + '\'' +
                ", answerC='" + answerC + '\'' +
                ", answerD='" + answerD + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
