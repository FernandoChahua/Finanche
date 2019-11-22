package com.finanzas.letter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.letter.repository.StartupCostRepository;

@RestController
@RequestMapping(path="/startupCost")
public class StartupCostController {
	@Autowired
	private StartupCostRepository startupCostRepository;
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable Long id) {
		startupCostRepository.deleteById(id);
	}
}
