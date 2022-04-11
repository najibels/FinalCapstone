package com.example.capstone.services;

import com.example.capstone.models.User;

import java.util.List;

public interface UserService {
//    static List<User> getAllUsers();

    List<User> getAllUsers();

    void saveUser(User user);
    User getUserById(long id);
    void deleteUserById(long id);

}
