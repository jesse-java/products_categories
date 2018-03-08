package com.naldojesse.productscategories.services;

import com.naldojesse.productscategories.models.Category;
import com.naldojesse.productscategories.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryService (CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public Optional<Category> findCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
}
