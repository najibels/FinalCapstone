package com.example.capstone.services;

import com.example.capstone.entity.Account;
import com.example.capstone.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service

public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private Account account;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }


    /**
     * Returns an Account object based on id argument.
     * <p>
     * Some more description of the method.
     *
     * @param  id  id of an Account
     * @return      Account object
     */
    @Override
    public Account getAccountById(long id) throws AccountNotFoundException {

        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            return account;
        }
        throw new AccountNotFoundException();
    }

    @Override
    public Account getAccountByName(String name) throws AccountNotFoundException {
        Account account = accountRepository.findByUserName(name);
        if (account == null) {
            throw new AccountNotFoundException();
        }
        return account;
    }

    @Override
    public void deleteAccountById(long id) {
        accountRepository.deleteById(id);
    }
}
