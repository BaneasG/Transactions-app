package com.agile.transactionsdemo.service.Impl;

import com.agile.transactionsdemo.entity.Account;
import com.agile.transactionsdemo.repository.AccountRepository;
import com.agile.transactionsdemo.service.AccountService;
import org.springframework.stereotype.Service;


//Here i'm using the methods from the Service Interface in order to give them body and make all the staff i want for the project.
@Service
public class AccountServiceImpl implements AccountService {


    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }



    //Implementing createAccount method.
    @Override
    public Account createAccount(Account account) {

        //Saves the body of the Account into the database.
        Account account1 = accountRepository.save(account);
        return account1;

    }


}

