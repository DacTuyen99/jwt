package com.example.demo.controller;

import com.example.demo.entity.ProductImage;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.ProductImgService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class UploadImgController {
    private final ProductImgService productImgService;

    @PostMapping("/upload-image")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ProductImage>> uploadImg(@RequestParam("image")List<MultipartFile> files, Authentication authentication) throws IOException {
        System.out.println("test" + authentication.getAuthorities().toString());
        return  ResponseEntity.ok(productImgService.uploadImg(files));
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        byte[] imageData = productImgService.getImage(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
    }
}
