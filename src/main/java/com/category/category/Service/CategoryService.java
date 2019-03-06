package com.category.category.Service;

import com.category.category.Category;

import java.util.List;

public interface CategoryService {
    public Category create(Category category);
    public Category findById(String id);
    public Category delete(String id);
    public Category update(Category category);
    public List<Category> findAll();
}
