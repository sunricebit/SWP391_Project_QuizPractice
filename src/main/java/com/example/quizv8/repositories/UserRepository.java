package com.example.quizv8.repositories;

import com.example.quizv8.model.QuizUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository  extends JpaRepository<QuizUser, Long> {
    Optional<QuizUser> getById(long id);
}
