package com.zemoga.profile.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zemoga.profile.interfaceService.ITwitterService;

import twitter4j.Status;
import twitter4j.TwitterException;

@RestController()
@RequestMapping("/user/{id}/tweets")
@CrossOrigin("*")
public class TwitterController {

	@Autowired
	private ITwitterService serviceTwitter;
	
	@GetMapping()
	public ResponseEntity<?> userGetTweets(@PathVariable Integer id) {
		try {
			Collection<Status> status=serviceTwitter.userGetTweets(id);
			if(!status.isEmpty()){
				return new ResponseEntity<Object>(status,HttpStatus.OK);
			}
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
				
		}catch(TwitterException te) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{q}")
	public ResponseEntity<?> userGetTweetsSearch(@PathVariable Integer id, @PathVariable String q) {
		try {
			Collection<Status> status=serviceTwitter.userGetTweetsSearch(id, q);
			if(!status.isEmpty()){
				return new ResponseEntity<Object>(status,HttpStatus.OK);
			}
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}catch(TwitterException te) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
