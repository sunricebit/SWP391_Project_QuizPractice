package com.example.quizv8.service;

import com.example.quizv8.model.QuestionDetail;

import java.util.List;

public interface IQuestionDetailService {
    public List<QuestionDetail> getAllQuestionDetail();
    public List<String> getAllTrueAnswer();
    public String getTrueAnswerByQuestion(Long questionId);
    public QuestionDetail saveQuestionDetail(QuestionDetail q);
    public List<QuestionDetail> getQuestionByQuizId(long quizListId);
    public void deleteQuestionDetail(QuestionDetail q);


}
