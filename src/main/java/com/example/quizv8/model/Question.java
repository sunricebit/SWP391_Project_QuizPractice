package com.example.quizv8.model;

import java.util.List;

public class Question {
    private QuestionDetail detail;
    private List<Answer> answers;

    public Question() {
    }

    public Question(QuestionDetail detail, List<Answer> answers) {
        this.detail = detail;
        this.answers = answers;
    }

    public QuestionDetail getDetail() {
        return detail;
    }

    public void setDetail(QuestionDetail detail) {
        this.detail = detail;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

}
