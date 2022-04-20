package com.example.ExpenseTracker.service;

import com.example.ExpenseTracker.model.User;
import com.example.ExpenseTracker.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
