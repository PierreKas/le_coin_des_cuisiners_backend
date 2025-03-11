package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.repository;

import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.ProductHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdHistoryRepository extends JpaRepository<ProductHistory,Integer> {
   @Query("SELECT h FROM ProductHistory h WHERE productCode=?1 ORDER BY newPurchasedDate DESC")
    public List<ProductHistory> findHistoryByCode(String productCode);
}
