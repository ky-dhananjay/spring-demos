package my.examples.dao;

import my.examples.model.Account;
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
            new Account("dy", "Silver"),
            new Account("Dj", "Silver"));
    }
}
