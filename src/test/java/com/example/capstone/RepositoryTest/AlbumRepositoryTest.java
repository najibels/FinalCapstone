package com.example.capstone.RepositoryTest;

import com.example.capstone.entity.Account;
import com.example.capstone.entity.Album;
import com.example.capstone.repos.AccountRepository;
import com.example.capstone.repos.AlbumRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlbumRepositoryTest {


    @Autowired
    private AlbumRepository albumRepository;

    @Test
    void findFirstByUserName_should_return_Account_given_valid_UserName() {

        Album DemonDayz = albumRepository.findByName("DemonDayz");
        Assertions.assertThat(DemonDayz.getName()).isEqualTo("DemonDayz");
    }





}
