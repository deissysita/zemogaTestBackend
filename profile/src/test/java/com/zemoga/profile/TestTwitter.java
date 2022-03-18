package com.zemoga.profile;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class TestTwitter extends ProfileApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testTweets() throws Exception {
		mockMvc.perform(get("/user/5/tweets")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));

	}
	
	@Test
	public void testTweetsSearch() throws Exception {
		String q="nasa";
		mockMvc.perform(get("/user/5/tweets/{q}",q))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}
}