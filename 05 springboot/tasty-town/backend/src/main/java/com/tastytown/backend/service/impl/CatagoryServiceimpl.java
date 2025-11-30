package com.tastytown.backend.service.impl;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastytown.backend.model.Catagory;
import com.tastytown.backend.repository.CatagoryRepo;
import com.tastytown.backend.service.ICatagoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CatagoryServiceimpl implements ICatagoryService{
   
    private final CatagoryRepo repo ;

    public List<Catagory> getCatagories() {
        return repo.findAll();
    }

    public Catagory getCatagoryById(String catId) {
        return repo.findById(catId).orElseThrow();
    }

    public Catagory addCatagory(Catagory cat) {
        return repo.save(cat);
    }

    public Catagory updateCatagory(Catagory updatedCatagory) {
        return repo.save(updatedCatagory);
    }

    public void deleteCatagory(String catId) {
        repo.deleteById(catId);
    }

	

}
