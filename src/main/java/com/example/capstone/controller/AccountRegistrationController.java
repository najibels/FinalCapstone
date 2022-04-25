package com.example.capstone.controller;

import com.example.capstone.entity.Account;
import com.example.capstone.services.AccountRegistrationDTO;
import com.example.capstone.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;



@Controller
@RequestMapping("/signup")
public class AccountRegistrationController {
    @Autowired

    private AccountService accountService;

    @ModelAttribute("account")
    public AccountRegistrationDTO accountRegistrationDTO() {
        return new AccountRegistrationDTO();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "signup";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("account") @Valid AccountRegistrationDTO accountDto, BindingResult result){

        Account existing = accountService.findByUserName(accountDto.getUserName());
        if (existing != null){
            result.rejectValue("userName", null, "There is already an account registered with that username");
        }

        if (result.hasErrors()){
            return "signup";
        }

        accountService.save(accountDto);
        return "redirect:/productList";
    }


}
