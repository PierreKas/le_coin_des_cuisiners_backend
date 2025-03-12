package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.controller;

import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.Transaction;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,RequestMethod.DELETE})
public class TransactionController {
    @Autowired
    public TransactionService transactionService;

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        List<Transaction> transactionList= transactionService.getAllTransactions();
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }
    @GetMapping("/by-date/{theDate}")
    public ResponseEntity<List<Transaction>> getTransactionsByDate(@PathVariable String theDate){
        List<Transaction> transactionListByDate= transactionService.getTransactionsByDate(theDate);
        return new ResponseEntity<>(transactionListByDate, HttpStatus.OK);
    }

    @PostMapping("/batch")
    public ResponseEntity<?> saveTransactionBatch(@RequestBody List<Transaction> transactions) {
        try {
            String billCode = transactionService.saveTransactionBatch(transactions);

            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Marchandise(s) vendue(s)");
            response.put("billCode", billCode);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", e.getMessage());

            HttpStatus status = HttpStatus.BAD_REQUEST;
            if (e.getMessage().contains("Le stock n'est pas suffisant")) {
                errorResponse.put("message", "Le stock n'est pas suffisant");
            }

            return new ResponseEntity<>(errorResponse, status);
        }
    }
}
