package com.example.sprint2.controller;

import com.example.sprint2.model.Topic;
import com.example.sprint2.service.imp.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/topic")
public class TopicController {
    @Autowired
    private ITopicService topicService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllTopic(@PathVariable Long id){
        return new ResponseEntity<>(topicService.getAllTopicByIdCate(id),HttpStatus.OK);
    }
}
