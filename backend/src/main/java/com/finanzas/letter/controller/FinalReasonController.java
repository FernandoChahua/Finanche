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

import com.finanzas.letter.model.FinalReason;
import com.finanzas.letter.repository.FinalReasonRepository;

@RestController
@RequestMapping("/finalReason")
public class FinalReasonController {

	
	@Autowired
	private FinalReasonRepository finalReasonService;

	
	@GetMapping
	public List<FinalReason> findAll() {
		return finalReasonService.findAll();
	}

	@PostMapping
	public FinalReason save(@RequestBody FinalReason entity) {
		return finalReasonService.save(entity);
	}
	@PutMapping
	public FinalReason update(@RequestBody FinalReason entity) {
		return finalReasonService.save(entity);
	}
	@GetMapping(path="/{id}")
	public FinalReason findById(@PathVariable Long id) {
		return finalReasonService.findById(id).orElse(null);
	}
	@DeleteMapping(path="/{id}")
	public FinalReason delete(@PathVariable Long id) {
		 finalReasonService.deleteById(id);
		 return finalReasonService.findById(id).orElse(null);
	}

}
