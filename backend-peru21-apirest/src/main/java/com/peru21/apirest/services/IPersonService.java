package com.peru21.apirest.services;

import java.util.List;

import com.peru21.apirest.entities.CivilStatus;
import com.peru21.apirest.entities.District;
import com.peru21.apirest.entities.Person;
import com.peru21.apirest.entities.Sex;

public interface IPersonService {

	public List<Person> finAll();

	public Person findById(Long id);

	public Person save(Person person);

	public void Delete(Long id);

	public List<District> findAllDistricts();

	public List<Sex> findAllSexs();

	public List<CivilStatus> findAllCivilStatus();

}
