package com.Projects.TwitterApi.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Projects.TwitterApi.model.Tweet;

public interface TweetRepo extends CrudRepository<Tweet, Integer> {

	Tweet save(Tweet tweet);
	
	Optional<List<Tweet>> findTweetsByuserName(String userName);
	
}
