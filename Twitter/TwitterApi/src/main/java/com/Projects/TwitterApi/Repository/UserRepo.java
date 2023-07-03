package com.Projects.TwitterApi.Repository;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Projects.TwitterApi.model.Users;


@Repository
public interface UserRepo extends CrudRepository<Users, Integer> {
	Users save(Users users);
	Users findByUserId(String userId);
	

}

