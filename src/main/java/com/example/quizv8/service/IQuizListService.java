package com.example.quizv8.service;


import com.example.quizv8.model.Exam;
import com.example.quizv8.model.ExamWithRank;
import com.example.quizv8.model.QuestionDetail;
import com.example.quizv8.model.QuizList;

import java.util.List;

public interface IQuizListService {
    public List<QuizList> getQuizByUserID(long userId);
    public boolean deleteQuestionDetail(long quizListId);
    public boolean deleteQuizList(long quizListId);
    public QuizList getQuizListById(long QuizListId);
    public List<QuizList> getQuizPublic(long stateId);

    public List<QuizList> getQuizByCategory(String categoryName);
    public Exam saveExam(Exam exam);
    public List<Exam> getAllExam(long uid);
    public List<ExamWithRank> getLeaderBoard(Exam current, long uid, long qid);
    public List<QuestionDetail> getAllQuestion(long quizListID);
    public QuizList saveQuiz(QuizList quizList);


}