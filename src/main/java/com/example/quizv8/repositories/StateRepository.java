package com.example.quizv8.repositories;

import com.example.quizv8.model.QuizState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<QuizState,Long> {
}
