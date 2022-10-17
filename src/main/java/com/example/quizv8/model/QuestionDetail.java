package com.example.quizv8.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Question_Details")
public class QuestionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "_questionNo")
    private long questionNo;
    @ManyToOne
    @JoinColumn(name = "id")
    private QuizList quizList;
    @Column(name = "_question")
    private String question;
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public QuestionDetail() {
    }

    public QuestionDetail(long questionNo, QuizList quizList, String question) {
        this.questionNo = questionNo;
        this.quizList = quizList;
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
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
}
