package com.example.quizv8.repositories;

import com.example.quizv8.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam,Long> {
    List<Exam> getAllByUserId(long uid);
}
