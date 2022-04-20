package com.example.capstone.repos;

import com.example.capstone.entity.Account;
import com.example.capstone.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AlbumRepository extends JpaRepository<Album, String> {


    Album findByName(String name);

}
