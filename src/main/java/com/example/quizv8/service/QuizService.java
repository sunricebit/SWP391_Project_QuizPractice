package com.example.quizv8.service;

import com.example.quizv8.model.QuizList;
import com.example.quizv8.repositories.QuizRepository;
import com.example.quizv8.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class QuizService implements IQuizService{
    @Autowired
    private QuizRepository quizRepository;
    @Override
    public void updateQuiz(long id, QuizList quiz) {
        if(quiz.equals(null)){
            return;
        }
        QuizList quiz1 = quizRepository.getById(id);
        if (quiz1!=null){
            quiz1.setActive(quiz.isActive());
            quiz1.setName(quiz.getName());
            quiz1.setVote(quiz.getVote());
            quiz1.setCategoryId(quiz.getCategoryId());
            quiz1.setStateId(quiz.getStateId());
            quizRepository.save(quiz1);
        }
    }

    @Override
    public boolean deleteQuiz(long id) {
        QuizList quiz1 = quizRepository.getById(id);
        if (quiz1!=null) quizRepository.delete(quiz1);
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
}
