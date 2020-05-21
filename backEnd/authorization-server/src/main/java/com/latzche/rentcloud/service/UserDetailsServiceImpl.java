package com.latzche.rentcloud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.latzche.rentcloud.model.AuthUserDetail;
import com.latzche.rentcloud.model.User;
import com.latzche.rentcloud.repository.UserDetailRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDetailRepository userDetailRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> optionalUser = userDetailRepository.findByUsername(username );
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong. Validate") );
		UserDetails userDetails=new AuthUserDetail(optionalUser.get());
		new AccountStatusUserDetailsChecker().check(userDetails);
		return userDetails;
	}

}
