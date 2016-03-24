package com.guorui.springmvc.controller;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import com.guorui.springmvc.dao.SpitterRepository;
import com.guorui.springmvc.entity.Spitter;

public class SpitterControllerTest {

	@Test
	public void testShowRegistrationForm() throws Exception {
		SpitterRepository spitterRepository = mock(SpitterRepository.class);
		
		SpitterController controller = new SpitterController(spitterRepository);
		
		MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/registrationForm.jsp")).build();
		
		mockMvc.perform(get("/spitter/register")).andExpect(view().name("registrationForm"));
		
		
	}
	
	@Test
	public void testSave() throws Exception{
		SpitterRepository spitterRepository = mock(SpitterRepository.class);
		Spitter spitter = new Spitter("Guo", "Rui", "bonn", "123");
		
		SpitterController controller = new SpitterController(spitterRepository);
		
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(post("/spitter/register")
				.param("firstName", "Guo")
				.param("lastName", "Rui")
				.param("username", "bonn")
				.param("password", "123"))
		.andExpect(redirectedUrl("/spitter/bonn"));
		
		verify(spitterRepository,atLeastOnce()).save(spitter);
	}
	
	@Test
	public void testShowSpitterProfile() throws Exception{
		SpitterRepository spitterRepository = mock(SpitterRepository.class);
		
		SpitterController controller = new SpitterController(spitterRepository);
		
		Spitter spitter = new Spitter("Guo", "Rui", "bonn", "123");
		when(spitterRepository.findByName("bonn")).thenReturn(spitter);
		
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spitter/bonn")).andExpect(view().name("profile"))
		.andExpect(model().attributeExists("spitter"))
		.andExpect(model().attribute("spitter", spitter));
	}

}
