package com.example.quizv8.repositories;

import com.example.quizv8.model.Exam;
import com.example.quizv8.model.QuizUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam,Long> {
    List<Exam> getAllByExamUser(QuizUser quizUser);
    List<Exam> findAllByQuizNameOrderByPercentageDesc(String quizName);
    List<Exam> getDistinctFirstByQuizNameOrderByPercentageDescDateDesc(String quizName);
}
