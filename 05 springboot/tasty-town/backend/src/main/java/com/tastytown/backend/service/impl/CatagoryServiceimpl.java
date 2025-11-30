package com.tastytown.backend.service.impl;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastytown.backend.model.Catagory;
import com.tastytown.backend.repository.CatagoryRepo;
import com.tastytown.backend.service.ICatagoryService;

@Service
public class CatagoryServiceimpl implements ICatagoryService{
    // @Autowired
    private  CatagoryRepo repo ;

    public List<Catagory> getCatagories() {
        return repo.findAll();
    }

    public Catagory getCatagoryById(String catId) {
        return repo.findById(catId).orElseThrow();
    }

    public void addCatagory(Catagory cat) {
        repo.save(cat);
    }

    public void updateCatagory(Catagory updatedCatagory) {
         repo.save(updatedCatagory);
    }

    public void deleteCatagory(String catId) {
        repo.deleteById(catId);
    }

	

}
