package com.example.userfeedback.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userfeedback.models.UserFeedback;

public interface UserFeedbackRepository extends JpaRepository<UserFeedback, Long> {

}
