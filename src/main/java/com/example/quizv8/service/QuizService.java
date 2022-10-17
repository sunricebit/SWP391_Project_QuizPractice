package com.example.quizv8.service;

import com.example.quizv8.model.QuizList;
import com.example.quizv8.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.quizv8.model.QuestionDetail;
import com.example.quizv8.repositories.QuizRepository;

@Service
public class QuizService implements IQuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void updateQuiz(long id, QuizList quiz) {
        if (quiz.equals(null)) {
            return;
        }
        QuizList quiz1 = quizRepository.getById(id);
        if (quiz1 != null) {
            quiz1.setActive(quiz.isActive());
            quiz1.setName(quiz.getName());
            quiz1.setVote(quiz.getVote());
            quiz1.setCategory(quiz.getCategory());
            quiz1.setState(quiz.getState());
            quizRepository.save(quiz1);
        }
    }

    @Override
    public boolean deleteQuiz(long id) {
        QuizList quiz1 = quizRepository.getById(id);
        if (quiz1 != null) quizRepository.delete(quiz1);
        return false;
    }

    @Override
    public List<QuizList> getAllQuiz() {
        List<QuizList> qList = quizRepository.findAll();
        return qList;
    }

    @Override
    public Optional<QuizList> getQuiz(long id) {
        return quizRepository.findById(id);
    }

    @Override
    public void saveQuiz(QuizList quiz) {
        quizRepository.save(quiz);
    }

    @Autowired
    private QuizListRepository quizListRepository;
    @Override
    public List<QuestionDetail> getAllQuestion(long quizListID) {
        QuizList quizList = quizListRepository.getById(quizListID);
        return questionRepository.getAllByQuizList(quizList);
    }

    @Autowired
    private AnswerRepository answerRepository;

}
