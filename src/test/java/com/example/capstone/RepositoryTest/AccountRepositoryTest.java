package com.example.capstone.RepositoryTest;
import com.example.capstone.entity.Account;
import com.example.capstone.repos.AccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class AccountRepositoryTest {


    @Autowired
    private AccountRepository accountRepository;

    @Test
    void findFirstByUserName_should_return_Account_given_valid_UserName() {

        Account najib = accountRepository.findByUserName("najib");
        Assertions.assertThat(najib.getUserName()).isEqualTo("najib");
}





}

