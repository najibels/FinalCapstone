package com.example.capstone.forms;

import com.example.capstone.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductFormValidator implements Validator {

    @Autowired
    private ProductDAO productDAO;

    // This validator only checks for the ProductForm.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == AlbumForm.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AlbumForm albumForm = (AlbumForm) target;

        // Check the fields of ProductForm.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "NotEmpty.productForm.code");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.productForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.productForm.price");

        String code = albumForm.getCode();
        if (code != null && code.length() > 0) {
            if (code.matches("\\s+")) {
                errors.rejectValue("code", "Pattern.albumForm.code");
            } else if (AlbumForm.isNewAlbum()) {
                Album album = productDAO.findAlbum(code);
                if (album != null) {
                    errors.rejectValue("code", "Duplicate.productForm.code");
                }
            }
        }
    }

}