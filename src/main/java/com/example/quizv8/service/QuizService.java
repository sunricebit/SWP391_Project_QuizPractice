package com.example.quizv8.service;

import com.example.quizv8.model.Answer;
import com.example.quizv8.model.Question;
import com.example.quizv8.model.QuestionDetail;
import com.example.quizv8.repositories.AnswerRepository;
import com.example.quizv8.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
public class QuizService implements IQuizService{
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<Question> getAllQuestion() {
        List<Answer> ans = answerRepository.findAll();
        List<QuestionDetail> quesDetail = quizRepository.findAll();
        List<Question> ques = new List<Question>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Question> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(Question question) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Question> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends Question> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Question get(int i) {
                return null;
            }

            @Override
            public Question set(int i, Question question) {
                return null;
            }

            @Override
            public void add(int i, Question question) {

            }

            @Override
            public Question remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Question> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Question> listIterator(int i) {
                return null;
            }

            @Override
            public List<Question> subList(int i, int i1) {
                return null;
            }
        };
        for (int i = 0; i < quesDetail.size(); i++) {
            List<Answer> answers = new List<Answer>() {
                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean contains(Object o) {
                    return false;
                }

                @Override
                public Iterator<Answer> iterator() {
                    return null;
                }

                @Override
                public Object[] toArray() {
                    return new Object[0];
                }

                @Override
                public <T> T[] toArray(T[] ts) {
                    return null;
                }

                @Override
                public boolean add(Answer answer) {
                    return false;
                }

                @Override
                public boolean remove(Object o) {
                    return false;
                }

                @Override
                public boolean containsAll(Collection<?> collection) {
                    return false;
                }

                @Override
                public boolean addAll(Collection<? extends Answer> collection) {
                    return false;
                }

                @Override
                public boolean addAll(int i, Collection<? extends Answer> collection) {
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> collection) {
                    return false;
                }

                @Override
                public boolean retainAll(Collection<?> collection) {
                    return false;
                }

                @Override
                public void clear() {

                }

                @Override
                public Answer get(int i) {
                    return null;
                }

                @Override
                public Answer set(int i, Answer answer) {
                    return null;
                }

                @Override
                public void add(int i, Answer answer) {

                }

                @Override
                public Answer remove(int i) {
                    return null;
                }

                @Override
                public int indexOf(Object o) {
                    return 0;
                }

                @Override
                public int lastIndexOf(Object o) {
                    return 0;
                }

                @Override
                public ListIterator<Answer> listIterator() {
                    return null;
                }

                @Override
                public ListIterator<Answer> listIterator(int i) {
                    return null;
                }

                @Override
                public List<Answer> subList(int i, int i1) {
                    return null;
                }
            };
            for (int j = 0; j < ans.size(); j++) {
                if(quesDetail.get(i).getQuestionNo()== ans.get(j).getQuestionID()){
                    answers.add(ans.get(j));
                }
            }
            Question q = new Question(quesDetail.get(i), answers);
            ques.add(q);
        }
        return ques;
    }



}
