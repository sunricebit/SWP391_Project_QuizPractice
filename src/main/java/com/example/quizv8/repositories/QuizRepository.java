package com.example.quizv8.repositories;
import com.example.quizv8.model.QuizList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<QuizList,Long> {
}
