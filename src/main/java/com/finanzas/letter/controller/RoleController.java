package com.finanzas.letter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.letter.model.Role;
import com.finanzas.letter.repository.RoleRepository;

@RestController
@RequestMapping(path = "/roles")
public class RoleController {
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping
	public List<Role> getRoles(){
		return roleRepository.findAll();
	}
	@PostMapping
	public Role postRole(@RequestBody Role requestBody) {
		return roleRepository.save(requestBody);
	}
}
