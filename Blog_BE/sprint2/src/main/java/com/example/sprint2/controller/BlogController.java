package com.example.sprint2.controller;

import com.example.sprint2.dto.imp.IBlogDto;
import com.example.sprint2.service.imp.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<?> getAllBlogs(@RequestParam(name = "page") int page) {
        Pageable pageable = PageRequest.of(page,4);
        return new ResponseEntity<>(blogService.pageListBlog(pageable), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Long id) {
        return new ResponseEntity<>(blogService.findByBlogId(id), HttpStatus.OK);
    }

    @GetMapping("/highView")
    public ResponseEntity<?> getBlogHighView() {
        return new ResponseEntity<>(blogService.getBlogHighView(), HttpStatus.OK);
    }

    @GetMapping("/current")
    public ResponseEntity<?> getListBlogCurrent() {
        return new ResponseEntity<>(blogService.listBlogCurrent(), HttpStatus.OK);
    }

    @GetMapping("/findBlog")
    public ResponseEntity<?> findBlogByTopic(@RequestParam(name = "id") Long id,
                                             @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new ResponseEntity<>(blogService.findBlogByTopic(pageable, id), HttpStatus.OK);
    }

}
