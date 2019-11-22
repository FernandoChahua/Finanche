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

import com.finanzas.letter.model.Letter;
import com.finanzas.letter.service.LetterService;

@RestController
@RequestMapping("/letter")
public class LetterController {

	
	@Autowired
	private LetterService letterService;

	
	@GetMapping
	public List<Letter> getAll() {
		List<Letter> letters = this.letterService.getAll();

		return letters;
	}

	@PostMapping
	public Letter save(@RequestBody Letter requestBody) {

		Letter letter = this.letterService.insertOrUpdate(requestBody);

		return letter;
	}
	@PutMapping
	public Letter update(@RequestBody Letter requestBody) {
		Letter letter = this.letterService.insertOrUpdate(requestBody);

		return letter;
	}
	@DeleteMapping(path="/{id}")
	public Letter deleteLetter(@PathVariable Long id) {
		return letterService.delete(id);
	}
}
