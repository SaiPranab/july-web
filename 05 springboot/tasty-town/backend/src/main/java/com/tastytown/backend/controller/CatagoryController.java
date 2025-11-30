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
import org.springframework.web.bind.annotation.RestController;

import com.tastytown.backend.model.Catagory;
import com.tastytown.backend.service.ICatagoryService;
// import com.tastytown.backend.service.impl.CatagoryServiceimpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CatagoryController {
    
    private final ICatagoryService service;

    

    @GetMapping("/catagories")
    public List<Catagory> getCatagories(){
        return service.getCatagories();
    }

     @GetMapping("/catarories/{catId}")
    public Catagory getCatagoryById(@PathVariable String catId){
        return service.getCatagoryById(catId);
    }

     @PostMapping("/catagories")
    public void addCatagory(@RequestBody Catagory cat){
        service.addCatagory(cat);
    }

    
    @PutMapping("/catagories")
    public void updateCatagory(@RequestBody Catagory updatedCatagory){
        service.updateCatagory(updatedCatagory);
    }

     @DeleteMapping("/catgories/{catId}")
    public void deleteCatagory(@PathVariable String catId){
       service.deleteCatagory(catId);
    }
}

