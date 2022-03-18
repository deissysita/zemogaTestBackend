package com.zemoga.profile.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zemoga.profile.interfaceService.IPortfolioService;
import com.zemoga.profile.model.PortfolioEntity;

@RestController()
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private IPortfolioService serviceUser;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> userGetById(@PathVariable Integer id) {
		try {
			Optional<PortfolioEntity> userEntity=serviceUser.userGetById(id);
			return userEntity.isPresent()?new ResponseEntity<PortfolioEntity>(userEntity.get(),HttpStatus.OK):new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/*@GetMapping("/{twitterUserName}")
	public ResponseEntity<?> userGetByUserName(@PathVariable String twitterUserName) {
		try {
			Optional<PortfolioEntity> userEntity=serviceUser.userGetByUserName(twitterUserName);
			return userEntity.isPresent()?new ResponseEntity<PortfolioEntity>(userEntity.get(),HttpStatus.OK):new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}*/
	
	@PutMapping("/{id}")
	public ResponseEntity<?> userUpdate(@PathVariable Integer id, @RequestBody PortfolioEntity user) {
		try {
			if(serviceUser.userGetById(id).isPresent()){
				PortfolioEntity userEntity=serviceUser.userUpdate(id,user);
				return userEntity!=null?new ResponseEntity<PortfolioEntity>(userEntity,HttpStatus.OK):new ResponseEntity<Object>(HttpStatus.NOT_MODIFIED);
			}else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);	
			}
		}catch(Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> userGet() {
		try {
			Collection<PortfolioEntity> users=serviceUser.userGetAll();
			return users.isEmpty()?new ResponseEntity<Object>(HttpStatus.NO_CONTENT):new ResponseEntity<Collection<PortfolioEntity>>(users,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}