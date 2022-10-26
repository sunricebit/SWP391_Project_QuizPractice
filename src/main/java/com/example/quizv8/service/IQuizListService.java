package com.example.quizv8.service;

<<<<<<< HEAD
import com.example.quizv8.model.Exam;
=======
import com.example.quizv8.model.QuestionDetail;
>>>>>>> 44983280f7a622ad61a096bf6539c05cb89badc6
import com.example.quizv8.model.QuizList;
import com.example.quizv8.model.QuizState;

import java.util.List;

public interface IQuizListService {
    public List<QuizList> getQuizByUserID(long userId);
    public boolean deleteQuestionDetail(long quizListId);
    public boolean deleteQuizList(long quizListId);
    public QuizList getQuizListById(long QuizListId);
    public List<QuizList> getQuizPublic(long stateId);

    public List<QuizList> getQuizByCategory(String categoryName);
<<<<<<< HEAD
    public Exam saveExam(Exam exam);
    public List<Exam> getAllExam(long uid);
=======
    public List<QuestionDetail> getAllQuestion(long quizListID);
    public QuizList saveQuiz(QuizList quizList);
>>>>>>> 44983280f7a622ad61a096bf6539c05cb89badc6
}
