package com.jt.jt_blogs.service;

import com.jt.jt_blogs.model.Blog;

import lombok.RequiredArgsConstructor;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final JdbcTemplate jdbcTemplate;

    public List<Blog> getBlogs() {
        Blog blog1 = new Blog(1, "Heading 1", "Description 1");
        Blog blog2 = new Blog(1, "Heading 2", "Description 2");
        Blog blog3 = new Blog(1, "Heading 3", "Description 3");

        return List.of(blog1, blog2, blog3);
    }

    public void createBlog(String heading, String description) {
        String query = "INSERT INTO blogs (heading, description) VALUES(?, ?)";
        jdbcTemplate.update(query, heading, description);
    }
}
