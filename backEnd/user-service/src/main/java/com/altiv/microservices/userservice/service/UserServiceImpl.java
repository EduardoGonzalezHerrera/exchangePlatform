package com.altiv.microservices.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altiv.business.model.dto.users.UserDTO;
import com.altiv.business.model.entity.users.User;
import com.altiv.microservices.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User save(UserDTO userDTO) {
		User entity=new User(userDTO.getEmail(),
							userDTO.getFirstName(),
							userDTO.getLastName(),
							userDTO.getAlias() ) ;
		return userRepository.save(entity);
	}

	@Override
	public User findById(int id) {
		Optional<User> user= userRepository.findById(id);
		if(user.isPresent() )
			return user.get();
		return null;
	}

	@Override
	public List<User> findByName(String firstName, String lastName) {
		Optional<List<User>> users=userRepository.findUserByName(firstName, lastName);
		if(users.isPresent()) {
			return users.get();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User update(UserDTO user) {
		Optional<User> entity=userRepository.findById(user.getId());
		if(entity.isPresent() ) {
			entity.get().setEmail(user.getEmail());
			entity.get().setFirstName(user.getFirstName() );
			entity.get().setLastName(user.getLastName() );
			entity.get().setAlias(user.getAlias() );
			return userRepository.save(entity.get());
		}
		return null;
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}

}
