package com.example.demo.repository;

import com.example.demo.entity.ProductMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMainRepository extends JpaRepository<ProductMain,Long> {
}
