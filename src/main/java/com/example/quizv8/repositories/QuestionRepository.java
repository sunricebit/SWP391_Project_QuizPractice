package com.example.quizv8.repositories;

import com.example.quizv8.model.QuestionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
public interface QuestionRepository extends JpaRepository<QuestionDetail, Long> {
}
