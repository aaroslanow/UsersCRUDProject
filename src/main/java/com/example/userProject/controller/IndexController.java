package com.example.userProject.controller;

import com.example.userProject.Model.User;
import com.example.userProject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

/**
 * Created by Adam on 21.03.2018.
 */
@Controller
public class IndexController {

    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "index";
    }

    @RequestMapping(value = {"/users"})
    @ResponseBody
    public Set<User> getUsers() {
        return userService.getUsers();

    }


    @PostMapping(value = {"", "/", "/index"})
    public String updateOrAddUser(@RequestBody User user) {
        userService.saveUser(user);
        return "redirect:/index";
    }

    @PostMapping(value = "/delete")
    public String deleteUser(@RequestBody User user) {
        userService.deleteById(user.getId());
        return "index";
    }


}
