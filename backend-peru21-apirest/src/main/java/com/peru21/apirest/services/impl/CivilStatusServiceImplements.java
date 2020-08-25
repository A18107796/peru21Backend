package com.peru21.apirest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peru21.apirest.DAO.ICivilStatusDAO;
import com.peru21.apirest.entities.CivilStatus;
import com.peru21.apirest.services.ICivilStatusService;

@Service
public class CivilStatusServiceImplements implements ICivilStatusService {

	@Autowired
	private ICivilStatusDAO dao;

	@Override
	@Transactional(readOnly = true)
	public List<CivilStatus> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public CivilStatus findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public CivilStatus save(CivilStatus civilStatus) {
		return dao.save(civilStatus);
	}

}
