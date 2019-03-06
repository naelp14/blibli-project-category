package com.category.category.Controller;

import com.category.category.Category;
import com.category.category.Service.CategoryService;
import com.category.category.Service.CategoryServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    ArrayList<Category> categories = new ArrayList<>();
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @RequestMapping(
            value="/categories",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )

    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @RequestMapping(
            value = "/categories",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @RequestMapping(
            value = "/categories/{idCategory}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public Category findById(@PathVariable("idCategory")String id){
        return categoryService.findById(id);
    }

    @RequestMapping(
            value = "/categories/delete/{idCategory}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Category delete(@PathVariable("idCategory") String idCategory){
        return categoryService.delete(idCategory);
    }

    @RequestMapping(
            value = "/categories/update/{idCategory}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }
}
