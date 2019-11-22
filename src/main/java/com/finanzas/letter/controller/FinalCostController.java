package com.finanzas.letter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.letter.repository.FinalCostRepository;

@RestController
@RequestMapping(path="/finalCost")
public class FinalCostController {
	@Autowired
	private FinalCostRepository finalCostRepository;
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable Long id) {
		finalCostRepository.deleteById(id);
	}
}
