package com.peru21.apirest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.peru21.apirest.entities.Users;

public interface IUserDAO extends JpaRepository<Users, Long>{
	
	public Users findByUserName(String username);
	
	@Query("select u from Users u where u.userName = ?1")
	public Users findByUserName2(String username);

}
