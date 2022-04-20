package com.example.capstone.forms;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.example.capstone.forms.CustomerForm;
import org.apache.commons.validator.EmailValidator;

import javax.validation.constraints.NotNull;

public class CustomerFormValidator {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String address;
    @NotNull
    private  String phone;

    public CustomerFormValidator(){

    }
}



//@Component
//public class CustomerFormValidator implements Validator {
//
//    private EmailValidator emailValidator = EmailValidator.getInstance();
//
//    // This validator only checks for the CustomerForm.
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return clazz == CustomerForm.class;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        CustomerForm custInfo = (CustomerForm) target;
//
//        // Check the fields of CustomerForm.
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.customerForm.name");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.customerForm.email");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.customerForm.address");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.customerForm.phone");
//
//        if (!emailValidator.isValid(custInfo.getEmail())) {
//            errors.rejectValue("email", "Pattern.customerForm.email");
//        }
//    }
//
//}
