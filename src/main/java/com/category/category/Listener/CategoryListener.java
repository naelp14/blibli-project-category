package com.category.category.Listener;

import com.category.category.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CategoryListener {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "categories")
    public void listenTopicBelajar(String body) throws Exception {
        Category category = objectMapper.readValue(body, Category.class);
        log.info("Receive Message {}{}", category.getIdCategory(), category.getNameCategory());
    }
}
