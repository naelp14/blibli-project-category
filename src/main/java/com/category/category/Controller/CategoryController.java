package com.category.category.Controller;

import com.category.category.Category;
import com.category.category.Service.CategoryService;
import com.category.category.Service.CategoryServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    ArrayList<Category> categories = new ArrayList<>();
    private CategoryService categoryService;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(
            value = "/categories",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Category> create(@RequestBody Category category) throws Exception {
        String json = objectMapper.writeValueAsString(category);
        kafkaTemplate.send("categories", json);
        return categoryService.create(category);
    }

    @RequestMapping(
            value = "/categories",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public Flux<Category> findAll() throws Exception {
        return categoryService.findAll();
    }

    @RequestMapping(
            value = "/categories/{idCategory}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public Mono<Category> findById(@PathVariable("idCategory") String id) {
        return categoryService.findById(id);
    }

    @RequestMapping(
            value = "/categories/delete/{idCategory}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Category> delete(@PathVariable("idCategory") String idCategory) {
        return categoryService.delete(idCategory);
    }

    @RequestMapping(
            value = "/categories/update/{idCategory}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Category> update(@RequestBody Category category) {
        return categoryService.update(category);
    }
}


