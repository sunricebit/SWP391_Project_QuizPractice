package com.example.quizv8.repositories;

import com.example.quizv8.model.QuizList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizListRepository extends JpaRepository<QuizList, Long> {
}
