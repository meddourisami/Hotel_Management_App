package com.project.hotel_management_app.controller;

import com.project.hotel_management_app.exception.UserAlreadyExistsException;
import com.project.hotel_management_app.model.User;
import com.project.hotel_management_app.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
public class AuthController {
    private final IUserService userService;

    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(User user) {
        try{
            userService.registerUser(user);
            return ResponseEntity.ok("Registration successful!");
        }catch(UserAlreadyExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
