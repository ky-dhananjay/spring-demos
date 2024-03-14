package org.example.aop.dao;

import org.example.aop.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDao implements IAccountDao{
    @Override
    public void addAccount(){
        System.out.println(getClass() + " creating a new account");
    }

    @Override
    public List<Account> findAccounts() {
        return List.of(new Account("John", "Silver"),
            new Account("Tindy", "Silver"),
            new Account("Dj", "Silver"));
    }
}
