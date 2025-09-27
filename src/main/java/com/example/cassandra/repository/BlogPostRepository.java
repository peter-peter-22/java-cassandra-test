package com.example.cassandra.repository;

import com.example.cassandra.entity.BlogPost;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.UUID;

public interface BlogPostRepository extends CassandraRepository<BlogPost, UUID> {
}
