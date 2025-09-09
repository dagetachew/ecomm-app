package com.dagim.ecomm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table
public class ProductTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String productId;
    private String name;
    private String brand;
    private String category;
    private double price;
    @Lob
    private String description;
    private Date createDate;
    private String imageFileName;
}
