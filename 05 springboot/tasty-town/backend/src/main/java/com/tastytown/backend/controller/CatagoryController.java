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

import com.tastytown.backend.model.Catagory;
import com.tastytown.backend.service.ICatagoryService;
// import com.tastytown.backend.service.impl.CatagoryServiceimpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/catagories")
public class CatagoryController {
    
    private final ICatagoryService service;

    

    @GetMapping("/get")
    public List<Catagory> getCatagories(){
        return service.getCatagories();
    }

     @GetMapping("/{catId}")
    public Catagory getCatagoryById(@PathVariable String catId){
        return service.getCatagoryById(catId);
    }

     @PostMapping("/addNewCatagory")
    public Catagory addCatagory(@RequestBody Catagory cat){
        return service.addCatagory(cat);
    }

    
    @PutMapping("/addCatagory")
    public Catagory updateCatagory(@RequestBody Catagory updatedCatagory){
       return service.updateCatagory(updatedCatagory);
    }

     @DeleteMapping("/delete/{catId}")
    public void deleteCatagory(@PathVariable String catId){
       service.deleteCatagory(catId);
    }
}

