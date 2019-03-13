package com.category.category;

import com.category.category.Repository.CategoryRepository;
import com.category.category.Service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.util.List;


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
        categoryRepository.save(category).block();
        Category result = categoryRepository.findById("1").block();
        Assert.assertNotNull("Tidak null",result);

        //Select All
        List<Category> list = categoryRepository.findAll().collectList().block();

        Assert.assertNotNull("List ada isi",list);

        boolean check = false;
        if(categoryRepository.findById("1") != null){
            check = true;
        }else{
            check = false;
        }

        Assert.assertTrue(check==true);

    }
}
