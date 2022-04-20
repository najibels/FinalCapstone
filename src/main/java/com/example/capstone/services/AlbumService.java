package com.example.capstone.services;

import com.example.capstone.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> getAllAlbums();

    void saveAlbum(Album album);

    Album getAlbumById(String id);

    Album getAlbumByName(String name);

    void deleteAlbumById(String id);
}