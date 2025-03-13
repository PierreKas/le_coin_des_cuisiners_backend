package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.service;

import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

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

    public Product addProduct(Product product){
        return productRepository.save(product);
    }
    public Product findProductByCode(String productCode){
        return productRepository.findProductByCode(productCode);
    }

    public Product updateProduct(int productId,Product updatedProduct){
      Optional<Product> existingProduct = productRepository.findById(productId);
      if (existingProduct.isPresent()){
         Product product = existingProduct.get();
         product.setProductName(updatedProduct.getProductName());
         product.setBrand(updatedProduct.getBrand());
         product.setPurchasedDate(updatedProduct.getPurchasedDate());
         product.setOtherExpenses(updatedProduct.getOtherExpenses());
         product.setPurchasedQuantity(updatedProduct.getPurchasedQuantity());
         product.setPurchasePrice(updatedProduct.getPurchasePrice());
         product.setRemainingQuantity(updatedProduct.getRemainingQuantity());
         product.setSellingPrice(updatedProduct.getSellingPrice());

          return productRepository.save(product);

      }else {
          return null;
      }

    }

    public void deleteProduct(int productId){

         productRepository.deleteById(productId);
    }


}
