package com.nikitin.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import com.nikitin.entities.Products;
import com.nikitin.services.ProductService;
import com.nikitin.services.exception.ProductNotFound;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    private ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @GetMapping(path="/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Products findById(@PathVariable("id") Long id) {
        return service.findById(id).orElseThrow(ProductNotFound::new);
    }

    @GetMapping(path="/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Products> findAll() {
        return service.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Products createProduct(@RequestBody Products product) {
        service.createOrUpdate(product);
        return product;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Products updateProduct(@RequestBody Products product) {
        service.createOrUpdate(product);
        return product;
    }
    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> notFoundExceptionHandler (ProductNotFound e) {
        return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
    }
}
