package com.altiv.microservices.userservice.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.altiv.business.model.dto.users.UserDTO;
import com.altiv.business.model.entity.users.User;
import com.altiv.microservices.userservice.service.UserService;

@RestController
@RequestMapping("/services/users")
public class UserServiceController {

	@Autowired
	UserService userService;
	
	@PostMapping(
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE } 
			)
	public ResponseEntity<User> save(@RequestBody UserDTO userDTO){
		User user=userService.save(userDTO);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public  ResponseEntity<List<User>>getAllUsers(){
		List<User> users=userService.findAll();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		
	}
	
	
}
