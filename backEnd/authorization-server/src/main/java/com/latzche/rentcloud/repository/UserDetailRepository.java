package com.latzche.rentcloud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.latzche.rentcloud.model.User;

public interface UserDetailRepository extends JpaRepository<User,Integer>  {

	Optional<User> findByUsername(String name);
	
}
