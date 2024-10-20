package com.lcwd.user.service.UserService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.UserService.entity.User;
import com.lcwd.user.service.UserService.service.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserServices userServices;

	@Autowired
	public UserController(UserServices userServices) {
		this.userServices = userServices;
	}

	@PostMapping("/signin")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userServices.crateUser(user));
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id) {
		//fatch user rating from rating services
		return ResponseEntity.ok(userServices.getUserById(id));
	}

	@GetMapping("/allusers")
	public List<User> getAllusers() {
		return userServices.getAllUser();
	}
}
