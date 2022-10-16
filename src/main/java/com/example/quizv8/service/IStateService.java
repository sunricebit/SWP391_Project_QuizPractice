package com.example.quizv8.service;

import com.example.quizv8.model.QuizState;

import java.util.List;
import java.util.Optional;

public interface IStateService {
    public List<QuizState> getAllState();
    public Optional<QuizState> getState(long id);
    public QuizState getQuizState(long id);
}
