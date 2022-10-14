package com.example.quizv8.service;

import com.example.quizv8.model.QuizList;
import com.example.quizv8.repositories.QuizListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
public class QuizListService implements IQuizListService {
    @Autowired
    private QuizListRepository quizListRepository;
    @Override
    public List<QuizList> getQuizByUserID(long id) {
        List<QuizList> quizLists =  quizListRepository.findAll();
        List<QuizList> userquiz = new List<QuizList>() {
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
            public Iterator<QuizList> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(QuizList quizList) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends QuizList> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends QuizList> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public QuizList get(int index) {
                return null;
            }

            @Override
            public QuizList set(int index, QuizList element) {
                return null;
            }

            @Override
            public void add(int index, QuizList element) {

            }

            @Override
            public QuizList remove(int index) {
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
            public ListIterator<QuizList> listIterator() {
                return null;
            }

            @Override
            public ListIterator<QuizList> listIterator(int index) {
                return null;
            }

            @Override
            public List<QuizList> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        for (int i = 0; i < quizLists.size(); i++) {
            if(quizLists.get(i).getUserId()==id){
                userquiz.add(quizLists.get(i));
            }

        }
        return userquiz;
    }
}
