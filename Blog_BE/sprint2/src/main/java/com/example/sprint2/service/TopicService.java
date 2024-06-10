package com.example.sprint2.service;

import com.example.sprint2.exp.BaseException;
import com.example.sprint2.model.Topic;
import com.example.sprint2.repository.ITopicRepository;
import com.example.sprint2.service.imp.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService implements ITopicService {
    @Autowired
    private ITopicRepository topicRepository;

    @Override
    public Iterable<Topic> getAllTopicByIdCate(Long id) {
        Iterable<Topic> list;
        try{
            list = topicRepository.getAllTopicByIdCate(id);
        }catch (Exception e){
            throw new BaseException("Not Blog Current");
        }
        return list;
    }
}
