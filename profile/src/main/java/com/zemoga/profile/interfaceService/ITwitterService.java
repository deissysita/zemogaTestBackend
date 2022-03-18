package com.zemoga.profile.interfaceService;

import java.util.Collection;

import org.springframework.stereotype.Component;

import twitter4j.Status;
import twitter4j.TwitterException;

@Component
public interface ITwitterService {
	public Collection<Status> userGetTweets(Integer id) throws TwitterException;
	public Collection<Status> userGetTweetsSearch(Integer id, String q) throws TwitterException;
}
