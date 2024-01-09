package com.clg_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clg_management.entity.EventEntiy;

public interface EventRepo extends JpaRepository<EventEntiy, Integer>{

}
