package com.example.quizv8.service;

import com.example.quizv8.model.QuizState;
import com.example.quizv8.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService implements IStateService {
    @Autowired
    private StateRepository stateRepository;


    @Override
    public List<QuizState> getAllState() {
        return stateRepository.findAll();
    }

    @Override
    public Optional<QuizState> getState(long id) {
        return stateRepository.getById(id);
    }
}
