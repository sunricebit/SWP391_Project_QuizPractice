package com.example.quizv8.service;

import com.example.quizv8.model.QuizList;
import com.example.quizv8.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.quizv8.model.Answer;
import com.example.quizv8.model.Question;
import com.example.quizv8.model.QuestionDetail;
import com.example.quizv8.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
    private AnswerRepository answerRepository;

    @Override
    public List<Question> getAllQuestion() {
        List<Answer> ans = answerRepository.findAll();
        List<QuestionDetail> questionDetails = questionRepository.findAll();
        List<Question> questions = new ArrayList<Question>();
        for (int i = 0; i < questionDetails.size(); i++) {

            List<Answer> answers = new ArrayList<Answer>();
            for (int j = 0; j < ans.size(); j++) {
                if (questionDetails.get(i).getQuestionNo() == ans.get(j).getQuestionID()) {
                    answers.add(ans.get(j));
                }
            }
            Question q = new Question(questionDetails.get(i), answers);
            questions.add(q);
        }
        return questions;
    }


}
