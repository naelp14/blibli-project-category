package com.category.category.Service;

import com.category.category.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService{

    private ArrayList<Category> categories = new ArrayList<>();

    @Override
    public Category create(Category category) {
        categories.add(category);
        return category;
    }

    @Override
    public Category findById(String id) {
        Category temp = new Category();
        for (int i=0;i<categories.size();i++){
            if(categories.get(i).getIdCategory().equals(id)){
                BeanUtils.copyProperties(categories.get(i),temp);
                return temp;
            }
        }
        return null;
    }

    @Override
    public Category delete(String id) {
        Category temp = new Category();
        for (int i=0;i<categories.size();i++){
            if(categories.get(i).getIdCategory().equals(id)){
                BeanUtils.copyProperties(categories.get(i),temp);
                categories.remove(i);
                return temp;
            }
        }
        return null;
    }

    @Override
    public Category update(Category category) {
        for(int i=0;i<categories.size();i++){
            if(categories.get(i).getIdCategory().compareTo(category.getIdCategory())==0){
                categories.get(i).setNameCategory(category.getNameCategory());
                return categories.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        return categories;
    }
}
