package com.guorui.springmvc.dao;

import com.guorui.springmvc.entity.Spitter;

public interface SpitterRepository {
	
	void save(Spitter spitter);
	
	Spitter findByName(String name);

}
