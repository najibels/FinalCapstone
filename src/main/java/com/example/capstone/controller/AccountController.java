package com.example.capstone.controller;

import com.example.capstone.entity.Account;
import com.example.capstone.services.AccountRegistrationDTO;
import com.example.capstone.services.AccountService;
//import com.example.myfirstfullstack.models.Account;
//import com.example.myfirstfullstack.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AccountController {

    private AccountService accountService;

    public AccountController() {
    }

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }



    @GetMapping("/accounts")
    public String getAllAccounts(Model model) {
        model.addAttribute("listAccounts", accountService.getAllAccounts());
        return "accounts";
    }

    @GetMapping("/showNewAccountForm")
    public String showNewAccountForm(Model model) {
        // create model attribute to bind form data
        Account account = new Account();
        model.addAttribute("account", account);
        return "new_account";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(@ModelAttribute("account") @Valid Account account,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "new_account";
        }

        // save account to database
        accountService.saveAccount(account);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) throws AccountNotFoundException {

        // get account from the service
        Account account = accountService.getAccountById(id);

        // set account as a model attribute to pre-populate the form
        model.addAttribute("account", account);
        return "update_account";
    }

    @GetMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable(value = "id") long id) {

        // call delete account method
        this.accountService.deleteAccountById(id);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }
}
