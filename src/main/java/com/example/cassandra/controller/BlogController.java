package com.example.cassandra.controller;

import com.example.cassandra.entity.BlogPost;
import com.example.cassandra.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/all")
    public List<BlogPost> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BlogPost get(@PathVariable UUID id) {
        return service.getPost(id);
    }

    @GetMapping("/search/{title}")
    public List<BlogPost> search(@PathVariable String title) {
        return service.findByTitle(title);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.deletePost(id);
        return "Blogpost deleted";
    }

    @PutMapping("/{id}")
    public BlogPost update(@PathVariable UUID id,@RequestBody BlogPost post){
        return service.updatePost(id,post.getContent());
    }
}