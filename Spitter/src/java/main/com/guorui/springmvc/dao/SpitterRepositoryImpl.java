package com.guorui.springmvc.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.guorui.springmvc.entity.Spitter;

@Component
public class SpitterRepositoryImpl implements SpitterRepository {
	
	private Map<String,Spitter> spitterMap = new HashMap<>();

	@Override
	public void save(Spitter spitter) {
		spitterMap.put(spitter.getUsername(), spitter);
	}

	@Override
	public Spitter findByName(String name) {
		return spitterMap.get(name);
	}

	@Override
	public Collection<Spitter> findAll() {
		return spitterMap.values();
	}

	
}
