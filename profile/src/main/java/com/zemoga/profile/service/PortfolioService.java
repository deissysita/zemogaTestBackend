package com.zemoga.profile.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zemoga.profile.interfaceService.IPortfolioService;
import com.zemoga.profile.model.PortfolioEntity;
import com.zemoga.profile.repository.IPortfolio;

@Component
public class PortfolioService implements IPortfolioService{

	@Autowired
	private IPortfolio data;
	
	public Optional<PortfolioEntity> userGetById(Integer id){
		return data.findById(id); 
	}
	
	public Optional<PortfolioEntity> userGetByUserName(String twitterUserName){
		return data.findByTwitterUserName(twitterUserName); 
	}
	
	public PortfolioEntity userUpdate(Integer id,PortfolioEntity user) {
		user.setIdportfolio(id);
		return data.save(user);
	}
	
	public Collection<PortfolioEntity> userGetAll(){
		return data.findAll();
	}
	
}
