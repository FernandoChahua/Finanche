package com.finanzas.letter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.letter.model.Account;
import com.finanzas.letter.service.AccountService;

@RestController
@RequestMapping(path = "/users")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@GetMapping(path = "/getByUsername/{username}")
	public Account getByUsername(@PathVariable String username) {
		return accountService.findByUsername(username);
	}
	
	@GetMapping
	public List<Account> getAll(){
		return accountService.getAll();
	}
	@GetMapping(path="/{id}")
	public Account getById(@PathVariable Long id) {
		return accountService.getOne(id);
	}
	@PostMapping
	public Account register(@RequestBody Account requestBody) {
		return accountService.register(requestBody);
	}
	
	@PutMapping
	public Account update(@RequestBody Account requestBody) {
		return accountService.register(requestBody);
	}
}
