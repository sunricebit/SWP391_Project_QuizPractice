package com.example.quizv8.repositories;

import com.example.quizv8.model.Answer;
import com.example.quizv8.model.QuestionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> getAllByQuestion(QuestionDetail questionDetail);
}
