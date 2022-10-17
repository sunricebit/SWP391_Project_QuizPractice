package com.example.quizv8.service;

import com.example.quizv8.model.Question;
import com.example.quizv8.model.QuizList;

import java.util.List;
import java.util.Optional;

public interface IQuizService {
    public void updateQuiz(long id, QuizList quiz);
    public boolean deleteQuiz(long id);
    public List<QuizList> getAllQuiz();
    public Optional<QuizList> getQuiz(long id);
    public void saveQuiz(QuizList quiz);
    public List<Question> getAllQuestion();

}
