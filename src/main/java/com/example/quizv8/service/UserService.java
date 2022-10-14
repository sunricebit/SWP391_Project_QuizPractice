package com.example.quizv8.service;

import com.example.quizv8.model.QuizUser;
import com.example.quizv8.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void updateUser(long id, QuizUser user) {
        if (user != null) {
            QuizUser user1 = userRepository.getById(id);
            if (user1 != null) {
                user1.setEmail(user.getEmail());
                user1.setPassword(user.getPassword());
                user1.setRole(user.getRole());
                userRepository.save(user1);
            }
        }
    }

    @Override
    public boolean deleteUser(long id) {
        if (id > 0) {
            QuizUser user1 = userRepository.getById(id);
            if (user1 != null) {
                userRepository.delete(user1);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<QuizUser> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(QuizUser user) {
        userRepository.save(user);
    }

    @Override
    public Optional<QuizUser> getUserbyEmail(String email) {
        List<QuizUser> list = getAllUser();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmail().equals(email)) {
                return Optional.ofNullable(list.get(i));
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<QuizUser> getUser(long id) {
        return userRepository.findById(id);
    }

}
