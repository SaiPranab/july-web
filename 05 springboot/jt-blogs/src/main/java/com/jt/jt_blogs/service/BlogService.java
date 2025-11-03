package com.jt.jt_blogs.service;

import com.jt.jt_blogs.model.Blog;

import lombok.RequiredArgsConstructor;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final JdbcTemplate jdbcTemplate;
    private static final String BLOGS_TABLE = "blogs";

    public List<Blog> getBlogs() {
        String query = "SELECT * FROM %s".formatted(BLOGS_TABLE);
        // List<Blog> existingBlogs = jdbcTemplate.query(query, (resultSet, rowNum) -> {
        // int id = resultSet.getInt("id");
        // String heading = resultSet.getString("heading");
        // String description = resultSet.getString("description");

        // return new Blog(id, heading, description);
        // });

        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Blog.class));
    }

    public void createBlog(String heading, String description) {
        String query = "INSERT INTO %s (heading, description) VALUES(?, ?)".formatted(BLOGS_TABLE);
        jdbcTemplate.update(query, heading, description);
    }

    public void deleteBlogById(String id) {
        String query = "DELETE FROM %s WHERE id=?".formatted(BLOGS_TABLE);
        jdbcTemplate.update(query, id);
    }

    public Blog getBlogById(String id) {
        String query = "SELECT * FROM %s WHERE id=?".formatted(BLOGS_TABLE);
        return jdbcTemplate.queryForObject(query, 
                                new BeanPropertyRowMapper<>(Blog.class), id);
    }

    public void updateBlog(Blog blog) {
        int id = blog.getId();
        String heading = blog.getHeading();
        String description = blog.getDescription();

        String query = "UPDATE %s SET heading = ?, description = ? WHERE id = ?".formatted(BLOGS_TABLE);
        jdbcTemplate.update(query, heading, description, id);
    }
}
