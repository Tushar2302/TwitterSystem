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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Projects.TwitterApi.Repository.TweetRepo;
import com.Projects.TwitterApi.Repository.UserRepo;
import com.Projects.TwitterApi.Service.TweetService;
import com.Projects.TwitterApi.model.Tweet;
import com.Projects.TwitterApi.model.Users;

@RestController
@RequestMapping("/tweet")
public class TweetController {

	@Autowired
	TweetRepo tweetRepo;
	
	@Autowired
	TweetService tweetService;
	
	@PostMapping("/createtweet") //works
	private String submitUserTweet(@RequestBody Tweet tweet) {
		
		 tweetService.submitTweetToDatabase(tweet);
		 return "Tweet Created Successfully";
	}
	
	@GetMapping("/alltweets")  //works
	private ResponseEntity<List<Tweet>> getAllTweets(){
		List<Tweet> tweetList=new ArrayList<>();
		tweetRepo.findAll().forEach(tweetList::add);
		return new ResponseEntity<List<Tweet>>(tweetList,HttpStatus.OK);
	}
	
	@GetMapping("/{tweetid}") //works
	private ResponseEntity<Tweet> getTweetDetails(@PathVariable("tweetid") int id) {
		Optional<Tweet> tweet=tweetRepo.findById(id);
		if(tweet.isPresent()) {
			return new ResponseEntity<Tweet>(tweet.get(),HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Tweet>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@GetMapping("/userTweets") ///works
	private ResponseEntity<List<Tweet>> getTweetByUserName(@RequestParam("userName") String userName){
		Optional<List<Tweet>> userTweetList= tweetRepo.findTweetsByuserName(userName);
		return new ResponseEntity<List<Tweet>>(userTweetList.get(),HttpStatus.FOUND);
	}
	
	
	@PutMapping("/{tweetid}")  //works
	private String updateUserById(@PathVariable("tweetid") int id, @RequestBody Tweet tweet) {
		Optional<Tweet> t=tweetRepo.findById(id);
		if(t.isPresent()) {
			Tweet existTweet=t.get();
			existTweet.setTweetId(tweet.getTweetId());
			existTweet.setUserName(tweet.getUserName());
			existTweet.setContent(tweet.getContent());
			existTweet.setTimestamp(tweet.getTimestamp());
			tweetRepo.save(existTweet);
			return "Tweet Update against Id "+ id;
		}else {
			return "Tweet details does not exist for tweetid "+id;
		}
	}
	@DeleteMapping("/{tweetid}") //works
	public String deleteTweetByTweetId(@PathVariable("tweetid") int id) {
		tweetRepo.deleteById(id);
		return "Tweet Deleted Successfully";
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAllTweets() {
		tweetRepo.deleteAll();
		return "All Tweets deleted Successfully..";
	}
	
	
	
}
