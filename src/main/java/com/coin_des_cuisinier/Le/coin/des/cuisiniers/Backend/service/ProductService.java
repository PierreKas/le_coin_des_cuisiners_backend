package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.service;

import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public List<Product> getLowQtyProducts(){
        return productRepository.findLowQtyProducts();
    }

    public List<Product> getOutOfStockProducts(){
        return productRepository.findOutOfStockProducts();
    }

}
