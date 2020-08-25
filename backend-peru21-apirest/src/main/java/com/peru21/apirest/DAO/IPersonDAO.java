package com.peru21.apirest.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.peru21.apirest.entities.CivilStatus;
import com.peru21.apirest.entities.District;
import com.peru21.apirest.entities.Person;
import com.peru21.apirest.entities.Sex;

public interface IPersonDAO extends JpaRepository<Person, Long> {

	@Query("from District")
	public List<District> findAllDistricts();

	@Query("from Sex")
	public List<Sex> findAllSexs();

	@Query("from CivilStatus")
	public List<CivilStatus> findAllCivilStatus();
}
