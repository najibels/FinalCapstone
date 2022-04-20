package com.example.capstone.services;

import com.example.capstone.entity.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();

    void saveAccount(Account account);

    Account getAccountById(long id) throws AccountNotFoundException;

    Account getAccountByName(String name) throws AccountNotFoundException;

    void deleteAccountById(long id);
}

