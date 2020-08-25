package com.peru21.apirest.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peru21.apirest.configs.Methods;
import com.peru21.apirest.entities.Student;
import com.peru21.apirest.services.IStudentService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class StudentRestController {

	@Autowired
	private IStudentService service;

	@Autowired
	private Methods methods;

	@GetMapping("/students")
	public List<Student> findAll() {
		return service.finAll();
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();
		try {
			service.Delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El estudiante a sido eliminadp con exito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
