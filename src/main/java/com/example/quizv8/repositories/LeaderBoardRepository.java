package com.example.quizv8.repositories;

import com.example.quizv8.model.LeaderBoard;
import com.example.quizv8.model.QuizList;
import com.example.quizv8.model.QuizUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LeaderBoardRepository extends JpaRepository<LeaderBoard, Long> {
    Optional<LeaderBoard> findByExamUserAndQuizPractice(QuizUser quizUser, QuizList quizList);
    List<LeaderBoard> getAllByOrderByPercentageDesc();
}
