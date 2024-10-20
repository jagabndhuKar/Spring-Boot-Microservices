package com.lcwd.user.service.UserService.Exception;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException () {
		super("User Not Found on server");
	}
	
	public UserNotFoundException (String massages) {
		super(massages);
	}
}
