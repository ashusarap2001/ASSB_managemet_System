package com.clg_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clg_management.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
