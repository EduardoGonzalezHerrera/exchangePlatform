package com.altiv.microservices.userservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.altiv.business.model.entity.users.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	@Query(value="select * from User u"
			+"where u.lastName = :lastName and u.firstName= :firstName",nativeQuery=true)
	Optional<List<User>> findUserByName(@Param("firstName")String firstName,
			                            @Param("lastName")String lastName );
	
}
