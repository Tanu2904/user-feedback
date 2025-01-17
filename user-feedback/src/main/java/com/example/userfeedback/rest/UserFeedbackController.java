package com.example.userfeedback.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userfeedback.models.UserFeedback;
import com.example.userfeedback.repo.UserFeedbackRepository;

@RestController
public class UserFeedbackController {

	@Autowired
	UserFeedbackRepository userFeedbackRepository;

	@PostMapping("/userFeedback")
	public ResponseEntity saveUserFeedback(@RequestBody UserFeedback feedback) {
		System.out.println(feedback);

		UserFeedback newFeedback = userFeedbackRepository.save(feedback);

		if (newFeedback == null) {
			return new ResponseEntity<String>("Error in saving User Feedback.", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("User Feedback saved Successfully.", HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:8090")
	@GetMapping("/userFeedbacks")
	public ResponseEntity getAllUserFeedbacks() {

		List<UserFeedback> userFeedbacks = userFeedbackRepository.findAll();

		return new ResponseEntity<List<UserFeedback>>(userFeedbacks, HttpStatus.OK);
	}

}
