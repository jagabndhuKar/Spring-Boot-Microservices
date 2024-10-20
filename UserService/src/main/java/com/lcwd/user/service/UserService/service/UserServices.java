package com.lcwd.user.service.UserService.service;

import java.util.List;

import com.lcwd.user.service.UserService.entity.User;

public interface UserServices {
public User crateUser(User user);
public List<User> getAllUser();
public User getUserById(String id);
public User updateUser(String id, User user);
public String deleteUser(String id);
}
