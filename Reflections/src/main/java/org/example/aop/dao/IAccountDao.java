package org.example.aop.dao;

import org.example.aop.model.Account;

import java.util.List;

public interface IAccountDao {
    void addAccount();
    List<Account> findAccounts();
}
