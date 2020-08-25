package com.peru21.apirest.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peru21.apirest.configs.Methods;
import com.peru21.apirest.entities.CivilStatus;
import com.peru21.apirest.entities.District;
import com.peru21.apirest.entities.Person;
import com.peru21.apirest.entities.Sex;
import com.peru21.apirest.services.IPersonService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PersonRestController {

	@Autowired
	private IPersonService service;

	@Autowired
	private Methods metods;

	@GetMapping("/persons")
	public List<Person> findAll() {
		return service.finAll();
	}

	@GetMapping("/persons/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {

		Person person = null;
		Map<String, Object> response = new HashMap<>();
		try {
			person = service.findById(id);
		} catch (DataAccessException e) {
			response = metods.DataAccessException(e);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (person == null) {
			response.put("mensaje",
					"El Cliente con el ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@PostMapping("/persons")
	public ResponseEntity<?> create(@Valid @RequestBody Person person, BindingResult result) {
		Person newPerson = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			/*
			 * List<String> errors = new ArrayList<>(); Map<String, String> errors2 = new
			 * HashMap<>();
			 * 
			 * for(FieldError err: result.getFieldErrors()) { errors2.put(err.getField(),
			 * err.getDefaultMessage()); }
			 */
			Map<String, String> prueba = new HashMap<>();
			prueba = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
			response.put("errors", prueba);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			newPerson = service.save(person);
		} catch (DataAccessException e) {
			response = metods.DataAccessException(e);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Nueva persona registrada en la base de datos.");
		response.put("person", newPerson);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/persons/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Person person, BindingResult result,
			@PathVariable("id") Long id) {
		Person personOld = service.findById(id);
		Person personUpdated = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			Map<String, String> prueba = new HashMap<>();
			prueba = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
			response.put("errors", prueba);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if (personOld == null) {
			response.put("mensaje",
					"La persona con el ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			personOld.setFirstName(person.getFirstName());
			personOld.setLastName(person.getLastName());
			personOld.setDni(person.getDni());
			personOld.setBirthday(person.getBirthday());
			personOld.setAddress(person.getAddress());
			personOld.setEmail(person.getEmail());
			personOld.setPhone(person.getPhone());
			personOld.setDistrict(person.getDistrict());
			personOld.setSex(person.getSex());
			personOld.setCivilStatus(person.getCivilStatus());

			personUpdated = service.save(personOld);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje",
				"La persona con el ID: " + personUpdated.getId() + " a sido actualizado correctamente.");
		response.put("person", personUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@GetMapping("/persons/district")
	public List<District> findAllDistricts() {
		return service.findAllDistricts();
	}

	@GetMapping("/persons/sexs")
	public List<Sex> findAllSexs() {
		return service.findAllSexs();
	}

	@GetMapping("/persons/civilstatus")
	public List<CivilStatus> findAllCivilStatus() {
		return service.findAllCivilStatus();
	}

	@DeleteMapping("/persons/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();
		try {
			service.Delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La persona a sido eliminada con exito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
