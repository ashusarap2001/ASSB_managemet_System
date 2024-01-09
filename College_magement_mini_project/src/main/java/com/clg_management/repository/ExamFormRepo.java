package com.clg_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clg_management.entity.ExamFormData;

public interface ExamFormRepo extends JpaRepository<ExamFormData , Integer> {

}
