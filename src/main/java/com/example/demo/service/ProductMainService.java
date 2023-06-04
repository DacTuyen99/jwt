package com.example.demo.service;

import com.example.demo.entity.ProductMain;
import com.example.demo.repository.ProductMainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductMainService {
    private final ProductMainRepository productMainRepository;

    public ProductMain uploadProduct(ProductMain productMain){
        return productMainRepository.save(productMain);
    }

    public ProductMain getById(Long id){
        return productMainRepository.findById(id).get();
    }
}
