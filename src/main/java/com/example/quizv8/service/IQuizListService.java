package com.example.quizv8.service;

import com.example.quizv8.model.QuizList;

import java.util.List;

public interface IQuizListService {
    public List<QuizList> getQuizByUserID(long id);
}
