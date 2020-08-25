package com.peru21.apirest.services;

import java.util.List;

import com.peru21.apirest.entities.CivilStatus;

public interface ICivilStatusService {
	public List<CivilStatus> findAll();

	public CivilStatus findById(Long id);

	public CivilStatus save(CivilStatus civilStatus);
}
