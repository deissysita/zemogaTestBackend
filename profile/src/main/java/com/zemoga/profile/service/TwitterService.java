package com.zemoga.profile.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zemoga.profile.interfaceService.IPortfolioService;
import com.zemoga.profile.interfaceService.ITwitterService;
import com.zemoga.profile.model.PortfolioEntity;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Component
public class TwitterService implements ITwitterService{
	
	@Autowired
	private IPortfolioService serviceUser;
	
	private Twitter twitter;
	
	public TwitterService() {
        this.twitter = TwitterFactory.getSingleton();
    }
	
	public Collection<Status> userGetTweets(Integer id) throws TwitterException{
		Optional<PortfolioEntity> user=serviceUser.userGetById(id);
		Collection<Status> status = null;
		if(user.isPresent()){
			status=this.twitter.getUserTimeline(user.get().getTwitterUserName(), new Paging(1, 5));
		}
		return status;
	}
	
	public Collection<Status> userGetTweetsSearch(Integer id, String q) throws TwitterException{
		Optional<PortfolioEntity> user=serviceUser.userGetById(id);
		Collection<Status> status = null;
		if(user.isPresent()){
			Query query= new Query();
			query.setQuery(q);
			query.setCount(5);
			QueryResult search = this.twitter.search(query );
			status = search.getTweets();
		}
		return status; 
	}	
}
