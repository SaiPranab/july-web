package com.jt.jt_blogs.service;

import com.jt.jt_blogs.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    public List<Blog> getBlogs() {
        Blog blog1 = new Blog(1, "Heading 1", "Description 1");
        Blog blog2 = new Blog(1, "Heading 2", "Description 2");
        Blog blog3 = new Blog(1, "Heading 3", "Description 3");

        return List.of(blog1, blog2, blog3);
    }
}
