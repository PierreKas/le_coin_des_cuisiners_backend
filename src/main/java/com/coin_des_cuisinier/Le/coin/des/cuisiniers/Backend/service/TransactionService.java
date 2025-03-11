package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.service;

import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.Transaction;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    public TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions (){
        return transactionRepository.findAll();
    }
    public List<Transaction> getTransactionsByDate (String theDate){
        return transactionRepository.findTransationsByDate(theDate);
    }
}
