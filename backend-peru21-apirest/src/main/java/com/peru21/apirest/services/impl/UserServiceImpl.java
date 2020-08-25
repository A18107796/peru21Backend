package com.peru21.apirest.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peru21.apirest.DAO.IUserDAO;
import com.peru21.apirest.entities.Users;
import com.peru21.apirest.services.IUserService;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

@Service
public class UserServiceImpl implements UserDetailsService, IUserService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private IUserDAO userDao;

	@Override
	@Transactional(readOnly = true)
	public Users findByUsername(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userDao.findByUserName(username);

		if (user == null) {
			String error = "Error en el login no existe el usuario: ".concat(username);
			logger.error(error);
			throw new UsernameNotFoundException(error);
		}

		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRole_name()))
				.peek(authority -> logger.trace("Role" + authority.getAuthority())).collect(Collectors.toList());

		return new User(user.getUserName(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

}
