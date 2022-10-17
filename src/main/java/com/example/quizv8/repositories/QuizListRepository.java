package com.example.quizv8.repositories;

import com.example.quizv8.model.Category;
import com.example.quizv8.model.QuizList;
import com.example.quizv8.model.QuizState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizListRepository extends JpaRepository<QuizList, Long> {
    List<QuizList> findQuizListByCategoryAndState(Category category, QuizState state);
    List<QuizList> findQuizListsByState(QuizState state);

//    List<QuizList> findById(long id);
}
