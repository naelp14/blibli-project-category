package com.category.category;

import com.category.category.Repository.CategoryRepository;
import com.category.category.Service.CategoryService;
import com.category.category.Service.CategoryServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;
    private CategoryRepository categoryRepository;
    Category category1 = new Category("123","Health");

    @Test
    public void testCreate(){
        categoryService.create(category1).block();
        Category test = categoryService.findById("123").block();
        Assert.assertNotNull(test);
        Category product = new Category("1","asdf");
        categoryService.create(product).block();
        List<Category> lists = categoryService.findAll().collectList().block();
        Assert.assertNotNull("Harus ada",product);
        Assert.assertTrue("List 3",lists.size()==3);
    }

    @Test
    public void testFindId(){

        Category product = categoryService.findById("kosong").block();
        Assert.assertTrue("Product harus null", product == null);

        categoryService.create(new Category("234","ababab")).block();
        Category test = categoryService.findById("234").block();
        Assert.assertTrue("ID harus ketemu", test.getNameCategory().equals("ababab"));
    }

    @Test
    public void testFindAll(){
        categoryService.create(new Category("234","ababab")).block();
        Category category = new Category("123","asdf");
        categoryService.create(category).block();
        List<Category> lists = categoryService.findAll().collectList().block();
        Assert.assertTrue("Size harus 2", lists.size()==3);
    }

    @Test
    public void testUpdate(){
        categoryService.create(new Category("234","ababab")).block();
        categoryService.update(new Category("234","hahaahh")).block();

        Category test = categoryService.findById("234").block();

        Assert.assertTrue("Nama harus terupdate", test.getNameCategory().equals("hahaahh"));

        Category product = categoryService.update(new Category("534","ababab")).block();

        //Assert.assertTrue(product==null);
    }

    @Test
    public void testDelete(){
        categoryService.delete("234").block();

        categoryService.create(new Category("234","ababab")).block();
        categoryService.create(new Category("534","hahaahh")).block();

        List<Category> lists = categoryService.findAll().collectList().block();

        //Assert.assertTrue("Size harus 2", lists.size()==2);

        categoryService.delete("534").block();
        Category pro = categoryService.findById("534").block();
        Assert.assertTrue("Harus di delete", pro==null);

        categoryService.delete("234").block();
        List<Category> hi = categoryService.findAll().collectList().block();
        //Assert.assertTrue("Size harus 0", hi.size()==0);
    }
}
