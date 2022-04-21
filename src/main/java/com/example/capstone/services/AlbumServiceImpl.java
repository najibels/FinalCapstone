package com.example.capstone.services;

import com.example.capstone.entity.Album;
import com.example.capstone.exceptions.AlbumExecption;
import com.example.capstone.forms.AlbumForm;
import com.example.capstone.repos.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javax.security.auth.login.AlbumNotFoundException;
import java.util.List;
import java.util.Optional;

@Service

public class AlbumServiceImpl implements AlbumService {

    private AlbumRepository albumRepository;


    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<com.example.capstone.entity.Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public void saveAlbum(AlbumForm album) {

    }





    /**
     * Returns an Album object based on id argument.
     * <p>
     * Some more description of the method.
     *
     * @param  id  id of an Album
     * @return      Album object
     */
    @Override
    public Album getAlbumById(String id) {

        Optional<Album> optionalAlbum = albumRepository.findById(id);
        if (optionalAlbum.isPresent()) {
            Album album = optionalAlbum.get();
            return album;
        }
        throw new AlbumExecption();
    }

    @Override
    public Album getAlbumByName(String name) throws AlbumExecption {
        Album album = albumRepository.findByName(name);
        if (album == null) {
            throw new AlbumExecption();
        }
        return album;
    }

    @Override
    public void deleteAlbumById(String id) {
        albumRepository.deleteById(id);
    }
}
