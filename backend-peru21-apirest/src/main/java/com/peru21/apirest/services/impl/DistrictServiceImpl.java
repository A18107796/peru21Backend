package com.peru21.apirest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peru21.apirest.DAO.IDistrictDAO;
import com.peru21.apirest.entities.District;
import com.peru21.apirest.services.IDistrictService;

@Service
public class DistrictServiceImpl implements IDistrictService {

	@Autowired
	private IDistrictDAO dao;

	@Override
	@Transactional(readOnly = true)
	public List<District> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public District findById(Long isd) {
		return dao.findById(isd).orElse(null);
	}

	@Override
	public District save(District district) {
		return dao.save(district);
	}

}
