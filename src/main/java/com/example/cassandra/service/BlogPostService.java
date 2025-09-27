package com.example.cassandra.service;

import com.example.cassandra.entity.BlogPost;
import com.example.cassandra.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository repository;

    @Autowired
    private CassandraTemplate cassandraTemplate;

    public BlogPost createPost(String title, String content) {
        UUID id = UUID.randomUUID();
        BlogPost post = new BlogPost(id, title, content);
        return repository.save(post);
    }

    public BlogPost getPost(UUID id) {
        return repository.findById(id).orElse(null);
    }

//    public void updatePost(UUID id, String newContent) {
//        BlogPost post = getPost(id);
//        if (post != null) {
//            post.setContent(newContent);
//            repository.save(post);
//        }
//    }

    public void deletePost(UUID id) {
        repository.deleteById(id);
    }
}
