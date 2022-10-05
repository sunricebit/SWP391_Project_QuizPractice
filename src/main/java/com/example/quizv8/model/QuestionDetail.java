package com.example.quizv8.model;

import javax.persistence.*;

@Entity
@Table(name = "Question_Details")
public class QuestionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "_questionNo")
    private long questionNo;
    @Column(name = "id")
    private long quizListID;
    @Column(name = "_question")
    private String question;

    public QuestionDetail() {
    }

    public QuestionDetail(long questionNo, long quizListID, String question) {
        this.questionNo = questionNo;
        this.quizListID = quizListID;
        this.question = question;
    }

    public long getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(long questionNo) {
        this.questionNo = questionNo;
    }

    public long getQuizListID() {
        return quizListID;
    }

    public void setQuizListID(long quizListID) {
        this.quizListID = quizListID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
