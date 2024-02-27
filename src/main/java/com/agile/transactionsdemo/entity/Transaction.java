package com.agile.transactionsdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //I use this annotation because I read that it gives a random content on my id.
     private Long id;                               //I did it because the id is going to be created when i use the method of creation from the TransactionController Class.

    @Column(name = "sourceaccountid")
    private Long sourceAccountId;

    @Column(name = "targetaccountid")
    private Long targetAccountId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "currency")
    private String currency;


}
