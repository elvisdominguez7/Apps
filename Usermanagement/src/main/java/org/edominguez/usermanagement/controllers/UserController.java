package org.edominguez.usermanagement.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.edominguez.usermanagement.exception.UserNotFoundException;
import org.edominguez.usermanagement.exception.InvalidInputException;
import org.edominguez.usermanagement.exception.InvoiceNotFoundException;
import org.edominguez.usermanagement.model.User;
import org.edominguez.usermanagement.repository.UserRepository;


import static org.edominguez.usermanagement.constant.ErrorFault.NO_USER_FOUND;




@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository repo;

	@PostMapping(value = "/user")
	@PreAuthorize("hasRole('Apps') or hasRole('Testers') ")
	public ResponseEntity<Object> createStudent(@RequestBody User user) {
		User savedUser = ((CrudRepository<User, Long>) repo).save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping(value = "{id}")
	@PreAuthorize("hasRole('Apps') or hasRole('Testers') ")
	@ApiOperation(value = "Retrieves a User Record by the specified id.", notes = "Id is required.", response = User.class)
	@ResponseBody
	public User retrieveUser(@PathVariable long id)
			throws UserNotFoundException, InvalidInputException, InvoiceNotFoundException {
		
		Optional<User> user = ((CrudRepository<User, Long>) repo).findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException(NO_USER_FOUND + id);

		return user.get();

	}

	@GetMapping(value = "/all")
	@PreAuthorize("hasRole('Apps') or hasRole('Testers') ")
	@ResponseBody
	public List<User> retrieveAllStudents() {
		return ((JpaRepository<User, Long>) repo).findAll();
	}



	@PutMapping(value = "user")
	@PreAuthorize("hasRole('Apps') or hasRole('Testers') ")
	@ResponseBody
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id) {

		Optional<User> userOptional = ((CrudRepository<User, Long>) repo).findById(id);

		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();

		user.setid(id);
		
		((CrudRepository<User, Long>) repo).save(user);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "{id}")
	@PreAuthorize("hasRole('Apps') or hasRole('Testers') ")
	@ResponseBody
	public void  deleteUser(@PathVariable long id)
			throws UserNotFoundException, InvalidInputException, InvoiceNotFoundException {
		((CrudRepository<User, Long>) repo).deleteById(id);

	}

}
