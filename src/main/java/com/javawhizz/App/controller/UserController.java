package com.javawhizz.App.controller;

import com.javawhizz.App.model.User;
import com.javawhizz.App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userService.saveUser(user);
        return "User added successfully";
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get")
    public User getUserById(@RequestParam int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/edit")
    public String editUser(@RequestBody User user) {
        userService.updateUser(user);
        return "User updated successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        User user = userService.getUserById(id);
        if(user == null) {
            return "User not found";
        }
        userService.deleteUser(user);
        return "User deleted successfully";
    }
}
