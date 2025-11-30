package com.tastytown.backend.service.impl;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastytown.backend.model.Category;
import com.tastytown.backend.repository.CategoryRepository;
import com.tastytown.backend.service.ICategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
   
    private final CategoryRepository repo ;

    public List<Category> getCategories() {
        return repo.findAll();
    }

    public Category getCategoryById(String catId) {
        return repo.findById(catId).orElseThrow();
    }

    public Category addCategory(Category cat) {
        return repo.save(cat);
    }

    public Category updateCategory(Category updatedCategory) {
        return repo.save(updatedCategory);
    }

    public void deleteCategory(String catId) {
        repo.deleteById(catId);
    }

	

}
