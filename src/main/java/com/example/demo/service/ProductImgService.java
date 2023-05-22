package com.example.demo.service;

import com.example.demo.entity.ProductImage;
import com.example.demo.repository.ProductImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductImgService {
    private final ProductImgRepository productImgRepository;
    private final String FOLDER_PATH = "C:\\Users\\ASUS\\Desktop\\img\\";

    public List<ProductImage> uploadImg(List<MultipartFile> files) throws IOException {
        List<ProductImage> productImageList = new ArrayList<>();
        for (MultipartFile multipartFile : files){
            String filePath = FOLDER_PATH + multipartFile.getOriginalFilename();
            ProductImage productImage = productImgRepository.save(ProductImage.builder()
                            .name(multipartFile.getName())
                            .type(multipartFile.getContentType())
                            .urlImg(filePath)
                            .build());
            multipartFile.transferTo(new File(filePath));
            productImageList.add(productImage);
        }
        if (productImageList!=null){
            return productImageList;
        }
        return null;
    }

    public byte[] getImage(Long id) throws IOException {
        Optional<ProductImage> productImage = productImgRepository.findById(id);
        if (productImage.isPresent()){
            String filePath = productImage.get().getUrlImg();
            byte[] images = Files.readAllBytes(new File(filePath).toPath());
            return images;
        }
        return null;
    }
}
