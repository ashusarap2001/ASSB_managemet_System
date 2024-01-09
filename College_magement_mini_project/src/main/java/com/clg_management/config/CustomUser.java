package com.clg_management.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.clg_management.entity.Student;


public class CustomUser implements UserDetails {

	private Student student;

	public CustomUser(Student user) {
		super();
		this.student = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(student.getRole());

		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return student.getPassword();
	}

	@Override
	public String getUsername() {
		return student.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
