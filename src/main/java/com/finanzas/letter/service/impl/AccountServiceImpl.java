package com.finanzas.letter.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.letter.model.Account;
import com.finanzas.letter.repository.AccountRepository;
import com.finanzas.letter.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	@Transactional
	public Account insertOrUpdate(Account entity) {
		// TODO Auto-generated method stub
		return accountRepository.save(entity);
	}

	@Override
	public Optional<Account> getOne(Long id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id);
	}

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	@Transactional
	public Account delete(Long id) {
		// TODO Auto-generated method stub
		Account deleted = accountRepository.findById(id).get();
		if(deleted != null) 
			accountRepository.deleteById(id);
		else 
			deleted = new Account();
		
		return deleted;
	}

}
