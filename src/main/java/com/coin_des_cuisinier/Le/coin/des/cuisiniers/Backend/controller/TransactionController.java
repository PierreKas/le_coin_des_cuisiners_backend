package coin.cuisiniers.dashboard_backend.controller;

import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.Transaction;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
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
}
