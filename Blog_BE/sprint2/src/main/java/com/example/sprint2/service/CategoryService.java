package com.example.sprint2.service;

import com.example.sprint2.exp.BaseException;
import com.example.sprint2.model.Category;
import com.example.sprint2.repository.ICategoryRepository;
import com.example.sprint2.service.imp.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        List<Category> list;
        try {
            list = categoryRepository.findAll();
        }catch (Exception e){
            throw new BaseException("Not Found Category");
        }
        return list;
    }
}
