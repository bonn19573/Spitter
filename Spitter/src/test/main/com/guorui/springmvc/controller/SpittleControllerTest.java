package com.guorui.springmvc.controller;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import com.guorui.springmvc.dao.SpittleRepository;
import com.guorui.springmvc.entity.Spittle;

public class SpittleControllerTest {

	@Test
	public void shouldShowRecentSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository mockRepository = mock(SpittleRepository.class);
		when(mockRepository.findSpittles(1000, 20)).thenReturn(expectedSpittles);
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		
		mockMvc.perform(get("/spittles")).andExpect(view().name("spittles")).andExpect(model().attributeExists("spittleList"))
				.andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
		
		
	}

	@Test
	public void shouldShowPagedSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(50);
		SpittleRepository mockRepository = mock(SpittleRepository.class);
		when(mockRepository.findSpittles(238900, 50)).thenReturn(expectedSpittles);
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		mockMvc.perform(get("/spittles?max=238900&count=50")).andExpect(view().name("spittles")).andExpect(model().attributeExists("spittleList"))
				.andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
	}
	
	@Test
	public void shouldShowOneSpittle() throws Exception{
		List<Spittle> spittleList = createSpittleList(1);
		SpittleRepository spittleRepository = mock(SpittleRepository.class);
		when(spittleRepository.findOne(12345)).thenReturn(spittleList.get(0));
		
		SpittleController sController = new SpittleController(spittleRepository);
		
		MockMvc mockMvc = standaloneSetup(sController).setSingleView(new InternalResourceView("/WEB-INF/views/spittle.jsp")).build();
		mockMvc.perform(get("/spittles/show?spittleId=12345")).andExpect(view().name("spittle")).andExpect(model().attributeExists("spittle"))
		.andExpect(model().attribute("spittle", spittleList.get(0)));		
		
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}

}
