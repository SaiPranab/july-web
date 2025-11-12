package com.jt.jt_blogs.service;

import com.jt.jt_blogs.model.Blog;
import com.jt.jt_blogs.repository.BlogRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository repository;

    public List<Blog> getBlogs() {
        List<Blog> existingBlogs = repository.findAll();
        return existingBlogs;
    }

    public void createBlog(String heading, String description) {
        Blog newBlog = Blog.builder()
                    .heading(heading)
                    .description(description)
                    .build();
        repository.save(newBlog);
    }

    public void deleteBlogById(int id) {
        Blog toDeleteBlog = getBlogById(id);
        repository.delete(toDeleteBlog);
    }

    public Blog getBlogById(int id) {
        // Optional<Blog> optBlog = repository.findById(id);
        // Blog blog = optBlog.orElseThrow();

        Blog blog = repository.findById(id).orElseThrow();
        return blog;
    }

    public void updateBlog(Blog blog) {
        repository.save(blog);
    }
}
