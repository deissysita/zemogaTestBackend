package com.zemoga.profile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@Table(name="portfolio", schema = "zemoga_test_db")
public class PortfolioEntity {
	
	@Id
	@GeneratedValue
	private Integer idportfolio=0;
	
	@Column(length=255)
	private String description="";
	
	@Column(name="experience_summary",length=255)
	private String experienceSummary="";
	
	private Integer id=0;
	
	@Column(name="image_url", length=255)
	private String imageUrl="";
	
	@Column(name="last_names", length=255)
	private String lastNames="";
	
	@Column(length=255)
	private String names="";
	
	@Column(length=255)
	private String tittle="";
	
	@Column(name="twitter_user_id", length=255)
	private String twitterUserId=""; 
	
	@Column(name="twitter_user_name", length=255)
	private String twitterUserName="";
	
	@Column(name="user_id", length=255)
	private String userId="";
	
	@Column(length=255)
	private String address="";
	
	@Column(length=255)
	private String email="";
	
	@Column(length=255)
	private String experience="";
	
	@Column(name="image_path", length=255)
	private String imagePath="";
	
	@Column(length=255)
	private String name="";
	
	@Column(length=255)
	private String phone="";
	
	@Column(name="twitter_user", length=255)
	private String twitterUser="";
	
	@Column(name="zip_code", length=255)
	private String zipCode="";
	
	@Column(length=255)
	private String title="";
}
