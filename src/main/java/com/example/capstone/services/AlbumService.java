package com.example.capstone.services;

import com.example.capstone.entity.Album;
import com.example.capstone.forms.AlbumForm;

import java.util.List;

public interface AlbumService {
    List<Album> getAllAlbums();

    void saveAlbum(AlbumForm album);

    Album getAlbumById(String id);

    Album getAlbumByName(String name);

    void deleteAlbumById(String id);
}