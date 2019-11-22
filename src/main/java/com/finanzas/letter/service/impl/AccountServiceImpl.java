package com.finanzas.letter.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.letter.model.Account;
import com.finanzas.letter.repository.AccountRepository;
import com.finanzas.letter.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public Account insertOrUpdate(Account entity) {
		return accountRepository.save(entity);
	}

	@Override
	public Optional<Account> getOne(Long id) {
		return accountRepository.findById(id);
	}

	@Override
	public List<Account> getAll() {
		return accountRepository.findAll();
	}

	@Override
	@Transactional
	public Account delete(Long id) {
		Account deleted = accountRepository.findById(id).get();
		if(deleted != null) 
			accountRepository.deleteById(id);
		else 
			deleted = new Account();
		
		return deleted;
	}

	@Override
	public Account findByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

	@Override
	public Account register(Account requestBody) {
		requestBody.setEmailValidated(true);
		requestBody.setRegisterDate(LocalDate.now());
		requestBody.setAccountStatus(1);
		if(requestBody.getId() == null) {
			requestBody.setPassword(passwordEncoder.encode(requestBody.getPassword()));
		}else {
			Account account = accountRepository.findById(requestBody.getId()).get();
			if(account.getUsername() == requestBody.getUsername()) {
				account.setFirstName(requestBody.getFirstName());
				account.setLastName(requestBody.getLastName());
			}else {
				return null;
			}
		}
		requestBody = accountRepository.save(requestBody);
		requestBody.setPassword("*******************");
		return requestBody;
	}

}
