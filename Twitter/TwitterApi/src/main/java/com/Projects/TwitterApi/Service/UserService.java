package com.Projects.TwitterApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.Projects.TwitterApi.Repository.UserRepo;
import com.Projects.TwitterApi.model.Users;

@Service
public class UserService {
	 
	@Autowired
	UserRepo userRepository;
	
	public Users submitMetaDataOfUser(Users user) {
		return userRepository.save(user);
	}
	
	public Users displayUserMetaData(String userid) {
		return userRepository.findByUserId(userid);
	}
	
}
