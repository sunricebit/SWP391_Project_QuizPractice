package com.example.quizv8.service;


import com.example.quizv8.model.*;

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
    public List<QuestionDetail> getAllQuestion(long quizListID);
    public QuizList saveQuiz(QuizList quizList);

    public List<QuizList> searchByPartName(String partName);

    //for leader board
    public long findExisted(LeaderBoard leaderBoard);
    public LeaderBoard getById (long id);
    public LeaderBoard saveLeaderBoard(LeaderBoard newLeader);
    public List<LeaderBoard> getTenLeaderBoard(long qid);
    public List<LeaderBoard> getAllLeaderBoard();

}
