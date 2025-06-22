package my.examples.dao;

import my.examples.model.Account;

import java.util.List;

public interface IAccountDao {
    void addAccount();
    List<Account> findAccounts();
}
