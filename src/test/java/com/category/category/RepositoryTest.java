package com.category.category;

import com.category.category.Repository.CategoryRepository;
import com.category.category.Service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testRepository(){
        Category category = new Category();
        category.setIdCategory("1");
        category.setNameCategory("nama");

        //Save or Update
        categoryRepository.save(category);

        //Select All
        Page<Category> list = categoryRepository.findAll(PageRequest.of(0,10));
        List<Category> page = list.getContent();
        list.getTotalElements();
        list.getTotalPages();

        Optional<Category> optional = categoryRepository.findById("1");
        if(optional.isPresent()){
            Category temp = optional.get();
        }else{
            //gak ada
        }

    }
}
