package com.example.quizv8.service;

import com.example.quizv8.model.Category;

import java.util.List;
import java.util.Optional;


public interface ICategoryService {
    List<Category> getAllCategory();

    Optional<Category> getCategory(long id);

    void saveCategory(Category c);


}
