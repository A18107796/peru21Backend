package com.peru21.apirest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peru21.apirest.entities.CivilStatus;

public interface ICivilStatusDAO extends JpaRepository<CivilStatus, Long> {

}
