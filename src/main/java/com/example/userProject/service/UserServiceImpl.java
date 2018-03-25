package com.example.userProject.service;

import com.example.userProject.Model.User;
import com.example.userProject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Adam on 21.03.2018.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public Set<User> getUsers() {
        Set<User> userSet = new HashSet<>();
        userRepository.findAll().iterator().forEachRemaining(userSet::add);
        return userSet;
    }

    @Override
    public User findById(Long id) {
        Optional<User> userOptional=userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new RuntimeException("User Not Found!");
        }
        return userOptional.get();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }


    @Override
    public void deleteById(Long idToDelete) {
            userRepository.deleteById(idToDelete);
        }

    }

