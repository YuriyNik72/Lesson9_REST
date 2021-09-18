package com.nikitin.repositories;

import com.nikitin.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Products, Long> {

}
