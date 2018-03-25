package com.example.userProject.repository;

import com.example.userProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Adam on 21.03.2018.
 */
public interface UserRepository extends JpaRepository<User,Long > {
}
