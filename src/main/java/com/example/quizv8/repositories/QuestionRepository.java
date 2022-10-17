package com.example.quizv8.repositories;

import com.example.quizv8.model.QuestionDetail;
import com.example.quizv8.model.QuizList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionDetail, Long> {
    List<QuestionDetail> getAllByQuizList(QuizList quizList);
}
