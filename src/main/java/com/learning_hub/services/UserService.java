package com.learning_hub.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning_hub.Entity.User;
import com.learning_hub.Repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	public User UserRegistration (User user) {
		return userRepository.save(user); 
		
	}
	
	public Optional<User> findByName(String userName){
		
		return userRepository.findByUsername(userName);
	}
	
	public Optional<User> findById(Long id){
		return userRepository.findById(id);

	}

	public boolean userNameExists(String name) {
		return userRepository.existsByUsername(name);
		
	}
	
	public boolean emailExists(String email) {
		return userRepository.existsByEmail(email);
		
	}
	public User ValidateLogin(String userName,String password) {
		
		Optional<User> userOption = userRepository.findByUsername(userName);
		if(userOption.isPresent()) {
			User user = userOption.get();
			if(user.getPassword().equals(password)) {
				
				return user;
				
			}
		}
		return null;
		
	}
}
