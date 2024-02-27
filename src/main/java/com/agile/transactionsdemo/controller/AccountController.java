package com.agile.transactionsdemo.controller;



import com.agile.transactionsdemo.entity.Account;
import com.agile.transactionsdemo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Creating the AccountController Class which gives me the port between controller layer and client layer.
@RestController
@RequestMapping("/api/Account")
public class AccountController {


    AccountService accountService;



    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Creating the Account entity. It actually creates my table "account".
    @PostMapping()
    public ResponseEntity<Account> createAnAccount(@RequestBody Account account){

        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

}
