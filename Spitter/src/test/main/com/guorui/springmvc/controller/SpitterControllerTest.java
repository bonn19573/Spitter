package com.guorui.springmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

public class SpitterControllerTest {

	@Test
	public void testShowRegistrationForm() throws Exception {
		SpitterController controller = new SpitterController();
		
		MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/registrationForm.jsp")).build();
		
		mockMvc.perform(get("/spitter/register")).andExpect(view().name("registrationForm"));
		
	}

}
