package com.agile.transactionsdemo.service.Impl;


import com.agile.transactionsdemo.entity.Account;
import com.agile.transactionsdemo.entity.Transaction;
import com.agile.transactionsdemo.repository.AccountRepository;
import com.agile.transactionsdemo.repository.TransactionRepository;
import com.agile.transactionsdemo.service.TransactionService;
import org.springframework.stereotype.Service;


//Here i'm using the methods from the Service Interface in order to give them body and make all the staff i want for the project.
@Service
public class TransactionServiceImpl implements TransactionService {




    AccountRepository accountRepository;


    private TransactionRepository transactionRepository;






    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
     }

    //makeTheTransaction method implementation.
    @Override
    public Transaction makeTheTransaction(Transaction transaction) {

        //Getting and saving the two ids that I want.
        Long sourceAccountId = transaction.getSourceAccountId();
        Long targetAccountId = transaction.getTargetAccountId();

        double amount = transaction.getAmount();

        //Get and create an instance of sourceAccountId in order to see if it exists.
        Account sourceAccount = accountRepository
                .findById(sourceAccountId)
                .orElseThrow(() -> new RuntimeException("Source account not found"));

        //Get and create an instance of targetAccountId in order to see if it exists.
        Account targetAccount = accountRepository
                .findById(targetAccountId)
                .orElseThrow(() -> new RuntimeException("Target account not found"));

        //Checking if i can do the transfer.
        if(sourceAccount.getBalance() < amount){
            throw new RuntimeException("Insufficient balance!");
        }

        //Creating and Saving the transfer logic.
        double newSourceBal = sourceAccount.getBalance() - amount;
        double newTargetBal = targetAccount.getBalance() + amount;

        //Set the new balances.
        sourceAccount.setBalance(newSourceBal);
        targetAccount.setBalance(newTargetBal);

        //Updating and saving my Account Entity into the database.
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        //Creating a new Transaction object where I save the new transaction.
        Transaction transaction1 = transactionRepository.save(transaction);//new Transaction(sourceAccountId, targetAccountId,amount, sourceAccount.getCurrency());



        return transaction1;


    }
}
