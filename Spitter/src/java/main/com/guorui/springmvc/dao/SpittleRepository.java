package com.guorui.springmvc.dao;

import java.util.List;

import com.guorui.springmvc.entity.Spittle;

public interface SpittleRepository {
	List<Spittle> findSpittles(long max, int count);
}