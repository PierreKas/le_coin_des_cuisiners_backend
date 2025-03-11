package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "purchase_price")
    private Float purchasePrice;

    @Column(name = "other_expenses")
    private Float otherExpenses;

    @Column(name = "selling_price")
    private Float sellingPrice;

    @Column(name = "purchased_quantity")
    private Integer purchasedQuantity;

    @Column(name = "remaining_quantity")
    private Integer remainingQuantity = 0;

    @Column(name = "purchased_date", nullable = false)
    private String purchasedDate;

    @Column(nullable = false)
    private String brand;
}
