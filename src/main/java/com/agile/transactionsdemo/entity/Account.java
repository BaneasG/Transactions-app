package com.agile.transactionsdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
@Entity
public class Account {

    @Id
    private Long id;

    @Column(name = "balance")
    private double balance;

    @Column(name = "currency")
    private String currency;

    @Column(name = "createdAt")
    private LocalDate createdAt;


}

