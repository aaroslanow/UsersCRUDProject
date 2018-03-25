package com.example.userProject.Bootstrap;

import com.example.userProject.Model.User;
import com.example.userProject.repository.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 21.03.2018.
 */
@Component
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {
    private final UserRepository userRepository;


    public BootstrapData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        userRepository.saveAll(getUsers());

    }

    private List<User> getUsers() {

        User user1 = new User();
        user1.setId(1L);
        user1.setName("Test");
        user1.setSurname("User1");
        user1.setYearOfBirth(1986);
        user1.setActive(true);

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Test");
        user2.setSurname("User2");
        user2.setYearOfBirth(1987);
        user2.setActive(false);
        userRepository.save(user1);
        userRepository.save(user2);
        List<User> listUser = new ArrayList<>();

        listUser.add(user1);
        listUser.add(user2);
        return listUser;
    }

}
