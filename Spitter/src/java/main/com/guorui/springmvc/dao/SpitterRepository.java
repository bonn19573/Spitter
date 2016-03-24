package com.guorui.springmvc.dao;

import java.util.Collection;

import com.guorui.springmvc.entity.Spitter;

public interface SpitterRepository {

	void save(Spitter spitter);

	Spitter findByName(String name);

	Collection<Spitter> findAll();
}
