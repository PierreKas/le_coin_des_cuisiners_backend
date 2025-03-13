package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.service;

import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;
    @Transactional
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @Transactional
    public List<Product> getLowQtyProducts(){
        return productRepository.findLowQtyProducts();
    }
    @Transactional
    public List<Product> getOutOfStockProducts(){
        return productRepository.findOutOfStockProducts();
    }
    @Transactional
    public Product addProduct(Product product){
//        List<Product> productList=productRepository.findAll();
//        for (Product existingProduct : productList){
//            if (existingProduct.getProductCode().equals(product.getProductCode())){
//                throw  new RuntimeException("This product code exists");
//            }
//        }

        if(productRepository.isProductCodeExist(product.getProductCode())){
            throw new RuntimeException("Product code exists");
        }
        return productRepository.save(product);
    }
    @Transactional
    public Product findProductByCode(String productCode){
        return productRepository.findProductByCode(productCode);
    }
    @Transactional
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

    @Transactional
    public Product restockProduct(int productId,Product updatedProduct){
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
    @Transactional
    public void deleteProduct(int productId){

         productRepository.deleteById(productId);
    }


}
