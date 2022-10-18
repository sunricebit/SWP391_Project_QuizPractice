package com.example.quizv8.service;

import com.example.quizv8.model.QuizUser;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public void updateUser(long id, QuizUser user);
    public boolean deleteUser(long id);
    public List<QuizUser> getAllUser();
    public QuizUser getUser(long id);
    public QuizUser saveUser(QuizUser user);
    public Optional<QuizUser> getUserbyEmail(String email);

}
