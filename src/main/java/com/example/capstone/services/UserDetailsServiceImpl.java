package com.example.capstone.services;

import com.example.capstone.entity.Account;

import com.example.capstone.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.enabled;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private AccountRepository accountRepository;
    @Autowired
    public UserDetailsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }





    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserName(username);
        System.out.println("Account= " + account);

        if (account == null) {
            throw new UsernameNotFoundException("User " //
                    + username + " was not found in the database");
        }

        // EMPLOYEE,MANAGER,..
//        String role = account.getUserRole();

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        // ROLE_EMPLOYEE, ROLE_MANAGER
//        GrantedAuthority authority = new SimpleGrantedAuthority(role);

//        grantList.add(authority);

        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        UserDetails userDetails = (UserDetails) new User(account.getUserName(), //
                account.getEncrytedPassword(), enabled, accountNonExpired, //
                credentialsNonExpired, accountNonLocked, grantList);

        return userDetails;
    }

}