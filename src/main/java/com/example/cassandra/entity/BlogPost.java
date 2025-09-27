package com.example.cassandra.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.UUID;

@Table("blog_posts")
public record BlogPost(
        @PrimaryKey UUID id,
        String title,
        String content
) {
}
