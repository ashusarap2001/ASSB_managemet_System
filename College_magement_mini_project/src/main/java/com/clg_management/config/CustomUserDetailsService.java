package com.clg_management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.clg_management.entity.Student;
import com.clg_management.repository.UserRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Student student = userRepo.findByEmail(username);
		//System.out.println(student);
		if (student == null) {
			throw new UsernameNotFoundException("user not found");
		} else {
			return new CustomUser(student);
		}

	}

}
