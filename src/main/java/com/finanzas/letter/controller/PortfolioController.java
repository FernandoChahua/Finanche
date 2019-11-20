package com.finanzas.letter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.letter.model.Portfolio;
import com.finanzas.letter.service.PortfolioService;

@RestController
@RequestMapping(path="/portfolio")
public class PortfolioController {
	@Autowired
	private PortfolioService portfolioService;
	
	@GetMapping
	public List<Portfolio> getAllPortFolios() {
		return portfolioService.getAll();
	}
	
	@GetMapping(path="/{id}")
	public Portfolio getByIdPortfolio(@PathVariable Long id) {
		return portfolioService.getOne(id).get();
	}
}
