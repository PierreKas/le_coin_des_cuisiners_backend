package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.repository;

import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product p where remainingQuantity<10 and remainingQuantity<>0")
    List<Product> findLowQtyProducts();

    @Query("SELECT p FROM Product p where remainingQuantity=0")
    List<Product> findOutOfStockProducts();

    @Query("SELECT p FROM Product p where productCode=?1")
    Product findProductByCode(String prodCode);

    boolean existsByProductCode(String productCode);

}
