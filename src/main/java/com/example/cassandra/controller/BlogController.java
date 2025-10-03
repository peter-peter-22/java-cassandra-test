package com.example.cassandra.controller;

import com.example.cassandra.entity.BlogPost;
import com.example.cassandra.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/posts")
public class BlogController {
    @Autowired
    private BlogPostService service;

    @PostMapping
    public BlogPost create(@RequestBody BlogPost post) {
        return service.createPost(post.getTitle(), post.getContent());
    }

    @GetMapping("/{id}")
    public BlogPost get(@PathVariable UUID id) {
        return service.getPost(id);
    }

    // Add update and delete endpoints similarly
}