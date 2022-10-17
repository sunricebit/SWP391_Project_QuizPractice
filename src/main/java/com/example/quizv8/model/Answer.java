package com.example.quizv8.model;

import javax.persistence.*;

@Entity
@Table(name = "Answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "_answerNo")
    private long answerNo;
    @ManyToOne
    @JoinColumn(name = "id")
    private QuestionDetail question;
    @Column(name = "_answer")
    private String answer;
    @Column(name = "_correct")
    private boolean correct;

    public Answer() {
    }

    public Answer(long answerNo, QuestionDetail question, String answer, boolean correct) {
        this.answerNo = answerNo;
        this.question = question;
        this.answer = answer;
        this.correct = correct;
    }

    public long getAnswerNo() {
        return answerNo;
    }

    public void setAnswerNo(long answerNo) {
        this.answerNo = answerNo;
    }

    public QuestionDetail getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDetail question) {
        this.question = question;
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
