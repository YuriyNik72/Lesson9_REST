package com.nikitin.services;

import com.nikitin.entities.Products;
import com.nikitin.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }


    public Products createOrUpdate(Products products){
        return repository.save(products);
    }


    public Optional<Products> findById(Long id){
        return repository.findById(id);
    }


    public List<Products> findAll (){
        return repository.findAll();
    }


    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
