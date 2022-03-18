package com.zemoga.profile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zemoga.profile.model.PortfolioEntity;

@Repository
public interface IPortfolio extends JpaRepository<PortfolioEntity, Integer>{
	Optional<PortfolioEntity> findByTwitterUserName(@Param("twitterUserName") String twitterUserName);
}
