package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.service;

import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.ProductHistory;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.repository.ProdHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdHistoryService {

    @Autowired
    public ProdHistoryRepository prodHistoryRepository;
    @Transactional
    public List<ProductHistory> getProductHistoryByCode(String productCode){
        return prodHistoryRepository.findHistoryByCode(productCode);
    }
}
