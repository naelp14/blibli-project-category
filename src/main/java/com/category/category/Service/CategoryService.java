package com.category.category.Service;

import com.category.category.Category;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CategoryService {
    Mono<Category> create(Category category);
    Mono<Category> findById(String id);
    Mono<Category> delete(String id);
    Mono<Category> update(Category category);
    Flux<Category> findAll();
}
