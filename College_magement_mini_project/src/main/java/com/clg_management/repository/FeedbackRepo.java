package com.clg_management.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.clg_management.entity.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

}
