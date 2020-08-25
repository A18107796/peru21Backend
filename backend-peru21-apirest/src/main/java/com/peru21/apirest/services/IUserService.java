package com.peru21.apirest.services;

import com.peru21.apirest.entities.Users;

public interface IUserService {

	public Users findByUsername(String username);

}
