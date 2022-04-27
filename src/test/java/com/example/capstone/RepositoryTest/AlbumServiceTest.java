package com.example.capstone.RepositoryTest;

import com.example.capstone.entity.Account;
import com.example.capstone.entity.Album;
import com.example.capstone.repos.AccountRepository;
import com.example.capstone.repos.AlbumRepository;
import com.example.capstone.services.AlbumService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlbumServiceTest {


    @Autowired
    private AlbumService albumService;

    @Test
    void findFirstByUserName_should_return_Account_given_valid_UserName() {

        Album DemonDayz = albumService.getAlbumByName("DemonDayz");
        Assertions.assertThat(DemonDayz.getName()).isEqualTo("DemonDayz");
    }

    @Test
    void findFirstAlbumID() {

        Album ABC = albumService.getAlbumById("ABC");
        Assertions.assertThat(ABC.getCode()).isEqualTo("ABC");
    }





}
