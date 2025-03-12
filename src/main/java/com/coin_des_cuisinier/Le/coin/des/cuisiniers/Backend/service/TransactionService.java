package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.service;

import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.Product;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.Transaction;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.repository.ProductRepository;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TransactionService {
    @Autowired
    public TransactionRepository transactionRepository;
    @Autowired
    public ProductRepository productRepository;

    public List<Transaction> getAllTransactions (){
        return transactionRepository.findAll();
    }
    public List<Transaction> getTransactionsByDate (String theDate){
        return transactionRepository.findTransationsByDate(theDate);
    }

    @Transactional
    public String saveTransactionBatch(List<Transaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            throw new IllegalArgumentException("No transactions provided");
        }

        // Generate bill code
        String billCode = generateBillCode();
        List<Transaction> transactionsToSave = new ArrayList<>();

        for (Transaction transaction : transactions) {
            // Find the product by product code
            Product product = productRepository.findProductByCode(transaction.getProductCode());

            if (product == null) {
                throw new RuntimeException("Product not found for code: " + transaction.getProductCode());
            }

            // Check if there's enough stock
            if (product.getRemainingQuantity() < transaction.getQuantity()) {
                throw new RuntimeException("Le stock n'est pas suffisant pour " + product.getProductName());
            }

            // Update transaction with product ID and bill code
            transaction.setProductId(product.getId());
            transaction.setBillCode(billCode);

            // Update product remaining quantity
            product.setRemainingQuantity(product.getRemainingQuantity() - transaction.getQuantity());
            productRepository.save(product);

            transactionsToSave.add(transaction);
        }

        // Save all transactions
        transactionRepository.saveAll(transactionsToSave);

        return billCode;
    }

    private String generateBillCode() {
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000;
        return LocalDateTime.now().toString() + "_" + randomNumber;
    }
}
