package com.peru21.apirest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peru21.apirest.entities.District;

public interface IDistrictDAO extends JpaRepository<District, Long>{

}
