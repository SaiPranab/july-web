package com.tastytown.backend.controller;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tastytown.backend.model.Category;
import com.tastytown.backend.service.ICategoryService;
// import com.tastytown.backend.service.impl.CategoryServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/catagories")
public class CategoryController {
    
    private final ICategoryService service;

    

    @GetMapping("/get")
    public List<Category> getCatagories(){
        return service.getCatagories();
    }

     @GetMapping("/{catId}")
    public Category getCatagoryById(@PathVariable String catId){
        return service.getCatagoryById(catId);
    }

     @PostMapping("/addNewCatagory")
    public Category addCatagory(@RequestBody Category cat){
        return service.addCatagory(cat);
    }

    
    @PutMapping("/addCatagory")
    public Category updateCatagory(@RequestBody Category updatedCategory){
       return service.updateCatagory(updatedCategory);
    }

     @DeleteMapping("/delete/{catId}")
    public void deleteCatagory(@PathVariable String catId){
       service.deleteCatagory(catId);
    }
}

