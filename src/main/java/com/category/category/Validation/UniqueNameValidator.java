package com.category.category.Validation;

import com.category.category.Category;
import com.category.category.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName,String> {

    private CategoryRepository categoryRepository;

    @Autowired
    public UniqueNameValidator(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value==null){
            return false;
        }
        Category category = categoryRepository.findByNameCategory(value).block();
        return category==null;
    }


}