package com.peru21.apirest.services;

import java.util.List;

import com.peru21.apirest.entities.Sex;

public interface ISexService {
	public List<Sex> findAll();

	public Sex findById(Long id);

	public Sex save(Sex sex);
}
