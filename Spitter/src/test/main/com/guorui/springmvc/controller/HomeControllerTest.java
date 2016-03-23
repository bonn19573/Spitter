package com.guorui.springmvc.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class HomeControllerTest {

	@Test
	public void testHome() {
		HomeController controller = new HomeController();
		String home = controller.home();
		assertEquals("home", home);
	}

}
