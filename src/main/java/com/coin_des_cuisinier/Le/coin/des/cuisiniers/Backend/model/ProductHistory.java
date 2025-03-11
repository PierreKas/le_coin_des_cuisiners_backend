package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_history")
@Data
public class ProductHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "new_product_name")
    private String newProductName;

    @Column(name = "old_product_name")
    private String oldProductName;

    @Column(name = "new_purchase_price")
    private Float newPurchasePrice;

    @Column(name = "old_purchase_price")
    private Float oldPurchasePrice;

    @Column(name = "new_other_expenses")
    private Float newOtherExpenses;

    @Column(name = "old_other_expenses")
    private Float oldOtherExpenses;

    @Column(name = "new_selling_price")
    private Float newSellingPrice;

    @Column(name = "old_selling_price")
    private Float oldSellingPrice;

    @Column(name = "new_purchased_quantity")
    private Integer newPurchasedQuantity;

    @Column(name = "old_purchased_quantity")
    private Integer oldPurchasedQuantity;

    @Column(name = "new_remaining_quantity")
    private Integer newRemainingQuantity;

    @Column(name = "old_remaining_quantity")
    private Integer oldRemainingQuantity;

    @Column(name = "new_purchased_date")
    private String newPurchasedDate;

    @Column(name = "old_purchased_date")
    private String oldPurchasedDate;

    @Column(name = "new_brand")
    private String newBrand;

    @Column(name = "old_brand")
    private String oldBrand;
}
