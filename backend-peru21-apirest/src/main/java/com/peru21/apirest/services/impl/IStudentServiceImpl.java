package com.peru21.apirest.services.impl;

import java.util.List;

import com.peru21.apirest.DAO.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peru21.apirest.entities.Student;
import com.peru21.apirest.services.IStudentService;

@Service
public class IStudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDAO dao;

	@Override
	@Transactional(readOnly = true)
	public List<Student> finAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Student findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public Student save(Student student) {
		return dao.save(student);
	}

	@Override
	public void Delete(Long id) {
		dao.deleteById(id);
	}

}
