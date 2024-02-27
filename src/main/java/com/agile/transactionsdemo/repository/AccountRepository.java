package com.agile.transactionsdemo.repository;

import com.agile.transactionsdemo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

//My repository layer. Actually it let me communicate with my database. My data outlives the application so I have to use it.
public interface AccountRepository extends JpaRepository<Account, Long> {

}
