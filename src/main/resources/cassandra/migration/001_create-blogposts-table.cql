CREATE TABLE IF NOT EXISTS blog_posts (
    id uuid PRIMARY KEY,
    title text,
    content text,
    view_count bigint
);