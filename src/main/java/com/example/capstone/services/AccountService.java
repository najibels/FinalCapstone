package com.example.capstone.services;

import com.example.capstone.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface AccountService extends UserDetailsService {
    List<Account> getAllAccounts();

    void saveAccount(Account account);

    Account getAccountById(long id) throws AccountNotFoundException;

    Account getAccountByName(String name) throws AccountNotFoundException;

    void deleteAccountById(long id);

    Account findByUserName(String userName);
    Account save(AccountRegistrationDTO registration);
}

