package com.example.demo.controller;

import com.example.demo.entity.ProductMain;
import com.example.demo.service.ProductMainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class ProductMainController {
    private final ProductMainService productMainService;
    @PostMapping("/upload-product")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProductMain> uploadProductMain(@RequestBody ProductMain productMain){
        return ResponseEntity.ok(productMainService.uploadProduct(productMain));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductMain> productById(@PathVariable Long id){
        return ResponseEntity.ok(productMainService.getById(id));
    }
}
