package com.peru21.apirest.services;

import java.util.List;

import com.peru21.apirest.entities.District;

public interface IDistrictService {

	public List<District> findAll();
	
	public District findById(Long id);
	
	public District save(District district);
}
