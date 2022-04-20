package com.example.capstone.forms;

import com.example.capstone.entity.Album;
//import com.example.capstone.repos.AlbumDAO;
import com.example.capstone.repos.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;


public class ProductFormValidator {
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
    @NotNull
    private String code;
    private String name;
    private double price;

    public ProductFormValidator() {
    }
}



//@Component
//public class ProductFormValidator implements Validator {
//
//    @Autowired
//    private AlbumRepository albumRepository;
//
//    // This validator only checks for the ProductForm.
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return clazz == AlbumForm.class;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        AlbumForm albumForm = (AlbumForm) target;
//
//        // Check the fields of ProductForm.
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "NotEmpty.productForm.code");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.productForm.name");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.productForm.price");
//
//        String code = albumForm.getCode();
//        if (code != null && code.length() > 0) {
//            if (code.matches("\\s+")) {
//                errors.rejectValue("code", "Pattern.albumForm.code");
//            } else if (AlbumForm.isNewAlbum()) {
//                Album album = albumRepository.getById();
//                if (album != null) {
//                    errors.rejectValue("code", "Duplicate.productForm.code");
//                }
//            }
//        }
//    }
//
//}