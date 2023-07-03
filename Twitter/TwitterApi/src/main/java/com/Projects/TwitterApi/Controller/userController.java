package com.Projects.TwitterApi.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projects.TwitterApi.Repository.UserRepo;
import com.Projects.TwitterApi.Service.UserService;
import com.Projects.TwitterApi.model.Users;

@RestController
@RequestMapping("/users")
public class userController {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserService userService;
	
	@PostMapping("")
	private String submitUser(@RequestBody Users user) {
		 userService.submitMetaDataOfUser(user);
		return "User Created Successfully.";
		
	}
	@GetMapping("/users")
	private ResponseEntity<List<Users>> getAllUsers(){
		List<Users> userList = new ArrayList<>();
		userRepo.findAll().forEach(userList::add);
		return new ResponseEntity<List<Users>>(userList,HttpStatus.OK);
	}
	
	@GetMapping("/{userid}")
	private Users getUserDetails(@PathVariable("userid") String userId) {
		return userService.displayUserMetaData(userId);
	}
	@PutMapping("/{userid}")
	private String updateUserById(@PathVariable("userid") int id, @RequestBody Users user) {
		Optional<Users> us=userRepo.findById(id);
		if(us.isPresent()) {
			Users existUser=us.get();
			existUser.setName(user.getName());
			existUser.setUserId(user.getUserId());
			existUser.setUserName(user.getUserName());
			existUser.setGender(user.getGender());
			userRepo.save(existUser);
			return "User details against Id "+ id+ " updated";
		}else {
			return "User details does not exist for userid "+id;
		}
	}
	@DeleteMapping("/{userid}")
	public String deleteUserByuserId(@PathVariable("userid") int id) {
		userRepo.deleteById(id);
		return "User Deleted Successfully";
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAllUsers() {
		userRepo.deleteAll();
		return "Users deleted Successfully..";
	}
	
}
