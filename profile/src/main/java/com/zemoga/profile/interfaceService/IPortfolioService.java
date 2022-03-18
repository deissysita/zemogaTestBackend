package com.zemoga.profile.interfaceService;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.zemoga.profile.model.PortfolioEntity;

@Component
public interface IPortfolioService {
	public Optional<PortfolioEntity> userGetById(Integer id);
	public Optional<PortfolioEntity> userGetByUserName(String twitterUserName);
	public PortfolioEntity userUpdate(Integer id, PortfolioEntity user);
	public Collection<PortfolioEntity> userGetAll();
}
