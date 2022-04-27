package com.example.capstone.RepositoryTest;
import com.example.capstone.entity.Account;
import com.example.capstone.entity.Album;
import com.example.capstone.repos.AccountRepository;
import com.example.capstone.services.AccountService;
import com.example.capstone.services.AlbumService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.security.auth.login.AccountNotFoundException;

@SpringBootTest
public class AccountServiceTest {


    @Autowired
    private AccountService accountService;

    @Test
    void findAccountUserName() throws AccountNotFoundException {

        Account Najib = accountService.getAccountByName("Najib");
        Assertions.assertThat(Najib.getUserName()).isEqualTo("Najib");
    }

    @Test
    void findAccountbyId() throws AccountNotFoundException {

        Account ABC = accountService.getAccountById(12);
        Assertions.assertThat(ABC.getId()).isEqualTo(12);
    }





}

