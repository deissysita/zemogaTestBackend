package com.zemoga.profile;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zemoga.profile.interfaceService.IPortfolioService;
import com.zemoga.profile.model.PortfolioEntity;

public class TestUser extends ProfileApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private IPortfolioService serviceUser;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetUser() throws Exception {
		mockMvc.perform(get("/user/5")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.twitterUserName").value("@LeoDiCaprio")).andExpect(jsonPath("$.id").value("111111"))
				.andExpect(jsonPath("$.userId").value("456")).andExpect(jsonPath("$.twitterUserId").value("Leonardo DiCaprio"));

	}
	
	@Test
	public void testGetUsers() throws Exception {
		mockMvc.perform(get("/user"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}
	
	@Test
	public void testUserUpdate() throws Exception {
		PortfolioEntity user=this.serviceUser.userGetById(1).get();
		user.setDescription("Descripcion modificada");
		user.setExperience("10 años");
		
		mockMvc.perform( MockMvcRequestBuilders
			      .put("/user/{id}",user.getIdportfolio())
			      .content(new ObjectMapper().writeValueAsString(user))
			      .contentType("application/json")
			      .accept("application/json"))
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.twitterUserName").value(user.getTwitterUserName()))
			      .andExpect(MockMvcResultMatchers.jsonPath("$.experienceSummary").value(user.getExperienceSummary()))
			      .andExpect(MockMvcResultMatchers.jsonPath("$.twitterUserId").value(user.getTwitterUserId()))
			      .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(user.getDescription()))
			      .andExpect(MockMvcResultMatchers.jsonPath("$.experience").value(user.getExperience()));
	}
}