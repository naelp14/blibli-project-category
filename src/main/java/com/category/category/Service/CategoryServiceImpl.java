package com.category.category.Service;

import com.category.category.Category;
import com.category.category.Repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Mono<Category> create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Mono<Category> findById(String id) {
        return categoryRepository.findById(id);
//        for (int i=0;i<categories.size();i++){
//            if(categories.get(i).getIdCategory().equals(id)){
//                BeanUtils.copyProperties(categories.get(i),temp);
//                return temp;
//            }
//        }
//        return null;
    }

    @Override
    public Mono<Category> delete(String id) {
//        Category temp = new Category();
//        for (int i=0;i<categories.size();i++){
//            if(categories.get(i).getIdCategory().equals(id)){
//                BeanUtils.copyProperties(categories.get(i),temp);
//                categories.remove(i);
//                return temp;
//            }
//        }
//        return null;
        Mono<Category> temp = categoryRepository.findById(id);
        return categoryRepository.deleteByIdCategory(id);
    }

    @Override
    public Mono<Category> update(Category category) {
//        for(int i=0;i<categories.size();i++){
//            if(categories.get(i).getIdCategory().compareTo(category.getIdCategory())==0){
//                categories.get(i).setNameCategory(category.getNameCategory());
//                return categories.get(i);
//            }
//        }
//        return null;
        Mono<Category> temp = categoryRepository.findById(category.getIdCategory());
        if(temp!=null){
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public Flux<Category> findAll() {
        return categoryRepository.findAll();
    }
}
