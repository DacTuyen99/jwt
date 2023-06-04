package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product_main")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductMain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private float price;
    private int size39;
    private int size40;
    private int size41;
    private int size42;
    private int size43;
    private int size44;
    private int size45;
    private Long[] imageId;

}
