package com.example.quizv8.service;

import com.example.quizv8.model.Category;
import com.example.quizv8.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategory(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void saveCategory(Category c) {
        categoryRepository.save(c);
    }
}
