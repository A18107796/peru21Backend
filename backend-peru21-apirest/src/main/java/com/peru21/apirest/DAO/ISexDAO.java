package com.peru21.apirest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peru21.apirest.entities.Sex;

public interface ISexDAO extends JpaRepository<Sex, Long>{
	
}
