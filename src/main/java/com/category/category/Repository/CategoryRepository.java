package com.category.category.Repository;

import com.category.category.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String>{
    Mono<Category> findById(String id);
    Flux<Category> findAllByNameCategory(String name);
    Mono<Category> deleteByIdCategory(String id);
    Mono<Category> findByNameCategory(String id);
}
