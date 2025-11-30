package com.tastytown.backend.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tastytown.backend.model.Catagory;

public interface ICatagoryService {
    
    public List<Catagory> getCatagories();
    public Catagory getCatagoryById(@PathVariable String catId);
    public Catagory addCatagory(@RequestBody Catagory cat);
    public Catagory updateCatagory(@RequestBody Catagory updatedCatagory);
    public void deleteCatagory(@PathVariable String catId);
}
