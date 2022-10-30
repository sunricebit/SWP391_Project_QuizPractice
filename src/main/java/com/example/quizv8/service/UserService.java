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

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public void updateUser(long id, QuizUser user) {
        if (user != null) {
            Optional<QuizUser> user1 = userRepository.getById(id);
            if (user1.isPresent()) {
                user1.get().setEmail(user.getEmail());
                user1.get().setPassword(user.getPassword());
                user1.get().setRole(user.getRole());
                userRepository.save(user1.get());
            }
        }
    }

    @Autowired
    private IQuizListService iQuizListService;
    @Override
    public boolean lockOrUnlock(long id) {
        Optional<QuizUser> user1 = userRepository.getById(id);
        if (user1.isPresent()) {
            if(user1.get().isStatus()){
                user1.get().setStatus(false);
            } else {
                user1.get().setStatus(true);
            }
            userRepository.save(user1.get());
            return true;
        }
        return false;
    }

    @Override
    public List<QuizUser> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public boolean saveUser(QuizUser user) {
        if(user.getEmail()!=null && user.getPassword()!=null && user.getRole()!=null){
            userRepository.save(user);
            return true;
        }
        return false;
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
    public QuizUser getUser(long id) {
        return userRepository.getById(id).get();
    }

}