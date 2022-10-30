package com.example.quizv8.service;

import com.example.quizv8.model.QuestionDetail;
import com.example.quizv8.model.QuizList;
import com.example.quizv8.repositories.QuestionDetailReository;
import com.example.quizv8.repositories.QuizListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionDetailService implements IQuestionDetailService{

    @Autowired
    private QuestionDetailReository questionDetailReository;
    @Autowired
    private QuizListRepository quizListRepository;

    @Override
    public List<QuestionDetail> getAllQuestionDetail() {
        return questionDetailReository.findAll();
    }

    @Override
    public List<String> getAllTrueAnswer() {
        ArrayList<String> list = new ArrayList<>();
        for (QuestionDetail qDetail:questionDetailReository.findAll()) {
            list.add(qDetail.getCorrectAnswer());
        }
        return list;
    }

    @Override
    public String getTrueAnswerByQuestion(Long questionId) {
        QuestionDetail q = questionDetailReository.getById(questionId);
        return q.getCorrectAnswer();
    }

    @Override
    public QuestionDetail saveQuestionDetail(QuestionDetail q) {
        return questionDetailReository.save(q);
    }

    @Override
    public List<QuestionDetail> getQuestionByQuizId(long quizListId) {
        QuizList q = quizListRepository.getReferenceById(quizListId);
        List<QuestionDetail> qDAllList = questionDetailReository.findAll();
        List<QuestionDetail> qDList = new ArrayList<>();
        for (QuestionDetail qD:qDAllList){
            if (qD.getQuizList().equals(q)){
                qDList.add(qD);
            }
        }
        return qDList;
    }

    @Override
    public void deleteQuestionDetail(QuestionDetail q) {
         questionDetailReository.delete(q);
    }
}
