package com.example.capstone.controller;

import com.example.capstone.models.User;
import com.example.capstone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService= userService;
    }




    // display list of employees
    @GetMapping("/")
    public String viewHomePage() {

        return "index";
    }
    @GetMapping("/about")
    public String viewAbout() {

        return "about";
    }
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }
    @GetMapping("/signup")
    public String signup(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }



    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        // save employee to database
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        User user = userService.getUserById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.userService.deleteUserById(id);
        return "redirect:/";
    }
}
