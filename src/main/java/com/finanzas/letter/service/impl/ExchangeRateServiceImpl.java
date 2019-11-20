package com.finanzas.letter.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.letter.model.ExchangeRate;
import com.finanzas.letter.repository.ExchangeRateRepository;
import com.finanzas.letter.service.ExchangeRateService;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{

	@Autowired
	ExchangeRateRepository exchangeRateRepository;
	@Transactional
	@Override
	public ExchangeRate insertOrUpdate(ExchangeRate entity) {
		// TODO Auto-generated method stub
		return exchangeRateRepository.save(entity);
	}

	@Override
	public Optional<ExchangeRate> getOne(Long id) {
		// TODO Auto-generated method stub
		return exchangeRateRepository.findById(id);
	}

	@Override
	public List<ExchangeRate> getAll() {
		// TODO Auto-generated method stub
		return exchangeRateRepository.findAll();
	}

	@Override
	@Transactional
	public ExchangeRate delete(Long id) {
		// TODO Auto-generated method stub
		ExchangeRate deleted = exchangeRateRepository.findById(id).get();
		if(deleted != null)
			exchangeRateRepository.deleteById(id);
		else
			deleted = new ExchangeRate();
		return deleted;
	}

}
