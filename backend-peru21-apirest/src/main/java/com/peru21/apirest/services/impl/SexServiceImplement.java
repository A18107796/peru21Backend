package com.peru21.apirest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peru21.apirest.DAO.ISexDAO;
import com.peru21.apirest.entities.Sex;
import com.peru21.apirest.services.ISexService;

@Service
public class SexServiceImplement implements ISexService {

	@Autowired
	private ISexDAO dao;

	@Override
	@Transactional(readOnly = true)
	public List<Sex> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Sex findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public Sex save(Sex sex) {
		return dao.save(sex);
	}

}
