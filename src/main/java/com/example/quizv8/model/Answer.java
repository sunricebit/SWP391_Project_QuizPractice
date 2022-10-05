package com.example.quizv8.model;

import javax.persistence.*;

@Entity
@Table(name = "Answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "_answerNo")
    private long answerNo;
    @Column(name = "id")
    private long questionID;
    @Column(name = "_answer")
    private String answer;
    @Column(name = "_correct")
    private boolean correct;

    public Answer() {
    }

    public Answer(long answerNo, long questionID, String answer, boolean correct) {
        this.answerNo = answerNo;
        this.questionID = questionID;
        this.answer = answer;
        this.correct = correct;
    }

    public long getAnswerNo() {
        return answerNo;
    }

    public void setAnswerNo(long answerNo) {
        this.answerNo = answerNo;
    }

    public long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(long questionID) {
        this.questionID = questionID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
