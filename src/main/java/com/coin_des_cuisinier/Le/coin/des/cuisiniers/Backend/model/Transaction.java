package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_Id")
    private Integer transactionId;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "product_Id")
    private Integer productId;

    private Integer quantity;

    @Column(name = "bill_code", nullable = false)
    private String billCode;

    @Column(name = "selling_date", nullable = false)
    private String sellingDate;

    @Column(name = "total_price")
    private Integer totalPrice;

    @ManyToOne
    @JoinColumn(name = "product_Id", insertable = false, updatable = false)
    private Product product;
}
