package com.altiv.microservices.userservice.service;

import java.util.List;

import com.altiv.business.model.dto.users.UserDTO;
import com.altiv.business.model.entity.users.User;

public interface UserService {

	User save(UserDTO userDTO);
	
	User findById(int id);
	
	List<User> findByName(String firstName,String lastName);
	
	List<User> findAll();
	
	User update(UserDTO user);
	
	void delete(int id);
	
	
}
