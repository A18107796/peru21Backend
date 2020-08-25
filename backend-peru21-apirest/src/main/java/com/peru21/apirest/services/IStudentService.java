package com.peru21.apirest.services;

import java.util.List;

import com.peru21.apirest.entities.Student;

public interface IStudentService {

	public List<Student> finAll();

	public Student findById(Long id);

	public Student save(Student student);

	public void Delete(Long id);
}
