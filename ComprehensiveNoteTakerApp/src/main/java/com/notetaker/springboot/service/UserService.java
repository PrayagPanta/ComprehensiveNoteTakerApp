package com.notetaker.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.notetaker.springboot.model.User;
import com.notetaker.springboot.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
