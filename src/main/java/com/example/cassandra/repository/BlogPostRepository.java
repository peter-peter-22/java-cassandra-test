package com.example.cassandra.repository;

import com.example.cassandra.entity.BlogPost;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BlogPostRepository extends CassandraRepository<BlogPost, UUID> {
    @Query(value = "SELECT * FROM blog_posts where title=:title")
    List<BlogPost> findByTitle(@Param("title") String title);
}
