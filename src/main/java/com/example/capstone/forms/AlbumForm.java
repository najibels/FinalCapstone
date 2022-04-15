package com.example.capstone.forms;

import com.example.capstone.entity.Album;
import org.springframework.web.multipart.MultipartFile;

public class AlbumForm {
    private String code;
    private String name;
    private double price;

    private boolean newAlbum = false;

    // Upload file.
    private MultipartFile fileData;

    public AlbumForm() {
        this.newAlbum= true;
    }

    public AlbumForm(Album album) {
        this.code = album.getCode();
        this.name = album.getName();
        this.price = album.getPrice();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(MultipartFile fileData) {
        this.fileData = fileData;
    }

    public boolean isNewAlbum() {
        return isNewAlbum();
    }

    public void setNewAlbum(boolean newAlbum) {
        this.newAlbum = newAlbum;
    }

}