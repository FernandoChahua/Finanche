package com.finanzas.letter.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.finanzas.letter.model.StartupReason;
import com.finanzas.letter.repository.StartupReasonRepository;

import com.finanzas.letter.service.StartupReasonService;

@Service
public class StartupReasonServiceImpl implements StartupReasonService{

	@Autowired
	StartupReasonRepository startupReasonRepository;
	
	@Transactional
	@Override
	public StartupReason insertOrUpdate(StartupReason entity) {
		// TODO Auto-generated method stub
		return startupReasonRepository.save(entity);
	}

	@Override
	public Optional<StartupReason> getOne(Long id) {
		// TODO Auto-generated method stub
		return startupReasonRepository.findById(id);
	}

	@Override
	public List<StartupReason> getAll() {
		// TODO Auto-generated method stub
		return startupReasonRepository.findAll();
	}

	@Override
	@Transactional
	public StartupReason delete(Long id) {
		// TODO Auto-generated method stub
		StartupReason deleted = startupReasonRepository.findById(id).get();
		if(deleted != null)
			startupReasonRepository.deleteById(id);
		else
			deleted = new StartupReason();
		return deleted;
	}

	

}
