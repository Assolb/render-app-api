package com.javawhizz.App.service;

import com.javawhizz.App.model.User;

import java.util.List;

public interface UserService {

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);

    public List<User> getAllUsers();

    public User getUserById(int id);
}
