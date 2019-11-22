package com.finanzas.letter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.letter.model.StartupReason;
import com.finanzas.letter.repository.StartupReasonRepository;

@RestController
@RequestMapping("/startupReason")
public class StartupReasonController {

	
	@Autowired
	private StartupReasonRepository startupReasonService;

	
	@GetMapping
	public List<StartupReason> findAll() {
		return startupReasonService.findAll();
	}

	@PostMapping
	public StartupReason save(@RequestBody StartupReason entity) {
		return startupReasonService.save(entity);
	}
	@PutMapping
	public StartupReason update(@RequestBody StartupReason entity) {
		return startupReasonService.save(entity);
	}
	@GetMapping(path="/{id}")
	public StartupReason findById(@PathVariable Long id) {
		return startupReasonService.findById(id).orElse(null);
	}
	@DeleteMapping(path="/{id}")
	public StartupReason delete(@PathVariable Long id) {
		 startupReasonService.deleteById(id);
		 return startupReasonService.findById(id).orElse(null);
	}

}