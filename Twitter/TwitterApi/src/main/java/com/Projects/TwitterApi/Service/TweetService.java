package com.Projects.TwitterApi.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projects.TwitterApi.Repository.TweetRepo;
import com.Projects.TwitterApi.model.Tweet;

@Service
public class TweetService {
	
	@Autowired
	UserService userService;
	
	@Autowired
	TweetRepo tweetRepo;
	
	public Tweet submitTweetToDatabase(Tweet tweet) {
		return tweetRepo.save(tweet);
	}
	
	public ArrayList<Tweet> retriveTweets(){
		
		ArrayList<Tweet> tweetList=(ArrayList<Tweet>) tweetRepo.findAll();
		
		for(int i=0;i<tweetList.size();i++) {
			Tweet tweetItem=tweetList.get(i);
			tweetItem.setUserName(userService.displayUserMetaData(tweetItem.getUserId()).getUserName());
		}
		return tweetList;
	}
}
