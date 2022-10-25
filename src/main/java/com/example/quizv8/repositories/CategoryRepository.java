package com.example.quizv8.repositories;

import com.example.quizv8.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findCategoryByCategoryName(String categoryName);
    Category getById(long id);
}
