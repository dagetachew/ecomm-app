package com.dagim.ecomm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private String userId;
    private String productId;
    private String productName;
    private int orderQuantity;
    private double unitPrice;
    private Date orderDate;

}
