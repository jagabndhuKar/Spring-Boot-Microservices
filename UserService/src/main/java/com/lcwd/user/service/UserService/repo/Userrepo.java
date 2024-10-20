package com.lcwd.user.service.UserService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.service.UserService.entity.User;

public interface Userrepo extends JpaRepository<User, String>{

}
