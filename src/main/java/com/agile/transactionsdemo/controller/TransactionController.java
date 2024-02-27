package com.agile.transactionsdemo.controller;


import com.agile.transactionsdemo.entity.Transaction;
import com.agile.transactionsdemo.service.TransactionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//Creating the TransactionController Class which gives me the port between controller layer and client layer.
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    TransactionService transactionService;




    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //Create a responseEntity in order to pass the transaction creation into my database.
    @PostMapping()
    public ResponseEntity<Transaction> makeTheTransactions(@RequestBody Transaction transaction){

        return new ResponseEntity<>(transactionService.makeTheTransaction(transaction), HttpStatus.CREATED);
    }





    






}
