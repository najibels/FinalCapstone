package com.example.capstone.services;

import com.example.capstone.entity.Account;
import com.example.capstone.entity.Role;
import com.example.capstone.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private Account account;

//    @Autowired
//    private AccountRepository accountRepository;


    private PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {

        this.accountRepository = accountRepository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
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

    @Override
    public Account findByUserName(String userName) {
        return accountRepository.findByUserName(userName);
    }

    @Override
    public Account save(AccountRegistrationDTO registration) {
        Account user = new Account();
        user.setUserName(registration.getUserName());
        user.setEncrytedPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER"),new Role("ROLE_ADMIN")));
        return accountRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = accountRepository.findByUserName(username);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getEncrytedPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

}
