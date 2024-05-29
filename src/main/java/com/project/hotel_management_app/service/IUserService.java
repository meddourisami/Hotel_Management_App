package com.project.hotel_management_app.service;

import com.project.hotel_management_app.model.User;

import java.util.List;

public interface IUserService {
    User registerUser(User user);
    List<User> getUsers();
    void deleteUser(String email);
    User getUser(String email) throws UsernameNotFoundException;
}