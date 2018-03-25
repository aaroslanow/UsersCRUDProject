package com.example.userProject.service;

import com.example.userProject.Model.User;

import java.util.Set;

/**
 * Created by Adam on 21.03.2018.
 */

public interface UserService {
    Set<User> getUsers();
    User findById(Long l);
    void saveUser(User user);
    void deleteById(Long idToDelete);
}
