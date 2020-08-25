package com.peru21.apirest.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peru21.apirest.DAO.IPersonDAO;
import com.peru21.apirest.entities.CivilStatus;
import com.peru21.apirest.entities.District;
import com.peru21.apirest.entities.Person;
import com.peru21.apirest.entities.Sex;
import com.peru21.apirest.services.IPersonService;



@Service
public class PersonServiceImplement implements IPersonService {

	@Autowired
	private IPersonDAO dao;
	
	Logger log = LoggerFactory.getLogger(IPersonService.class);
	
	@Override
	@Transactional(readOnly = true)
	public List<Person> finAll() {
		log.info("Listar todo correcto");
		return dao.findAll();
		
	}

	@Override
	@Transactional(readOnly = true)
	public Person findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public Person save(Person person) {
		return dao.save(person);
	}

	@Override
	public void Delete(Long id) {
		dao.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public List<District> findAllDistricts() {
		return dao.findAllDistricts();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sex> findAllSexs() {
		return dao.findAllSexs();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CivilStatus> findAllCivilStatus() {
		return dao.findAllCivilStatus();
	}



}
