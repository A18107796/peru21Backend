package com.peru21.apirest.configs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
public class Methods {

	public Map<String, Object> DataAccessException(DataAccessException e) {
		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "Error al realizar la operacion en la base de datos");
		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		return response;
	}

}
