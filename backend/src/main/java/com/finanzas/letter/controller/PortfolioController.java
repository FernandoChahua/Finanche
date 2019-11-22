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

import com.finanzas.letter.model.Portfolio;
import com.finanzas.letter.service.PortfolioService;

@RestController
@RequestMapping(path="/portfolios")
public class PortfolioController {
	@Autowired
	private PortfolioService portfolioService;
	
	@GetMapping
	public List<Portfolio> getAllPortFolios() {
		return portfolioService.getAll();
	}
	
	@GetMapping(path="/{id}")
	public Portfolio getByIdPortfolio(@PathVariable Long id) {
		return portfolioService.getOne(id);
	}
	@PostMapping
	public Portfolio savePortfolio(@RequestBody Portfolio requestBody) {
		return portfolioService.insertOrUpdate(requestBody);
	}
	@GetMapping(path="/user/{id}")
	public List<Portfolio> getByIdUser(@PathVariable Long id) {
		return portfolioService.findByUserId(id);
	}
	@PutMapping
	public Portfolio updatePortfolio(@RequestBody Portfolio requestBody) {
		return portfolioService.insertOrUpdate(requestBody);
	}
	@DeleteMapping(path="/{id}")
	public Portfolio deletePortfolio(@PathVariable Long id) {
		return portfolioService.delete(id);
	}
}
