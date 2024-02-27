package com.agile.transactionsdemo.service;

import com.agile.transactionsdemo.entity.Transaction;

//Service interface in order to define every method im going to use.
public interface TransactionService {
    //Transaction method
    Transaction makeTheTransaction(Transaction transaction);
}

