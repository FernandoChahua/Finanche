package com.finanzas.letter.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.letter.model.StartupCost;
import com.finanzas.letter.repository.StartupCostRepository;
import com.finanzas.letter.service.StartupCostService;

@Service
public class StartupCostServiceImpl implements StartupCostService{

	@Autowired
	StartupCostRepository startupCostRepository;
	
	@Transactional
	@Override
	public StartupCost insertOrUpdate(StartupCost entity) {
		// TODO Auto-generated method stub
		return startupCostRepository.save(entity);
	}

	@Override
	public Optional<StartupCost> getOne(Long id) {
		// TODO Auto-generated method stub
		return startupCostRepository.findById(id);
	}

	@Override
	public List<StartupCost> getAll() {
		// TODO Auto-generated method stub
		return startupCostRepository.findAll();
	}

	@Override
	public StartupCost delete(Long id) {
		// TODO Auto-generated method stub
		StartupCost deleted = startupCostRepository.findById(id).get();
		if(deleted != null)
			startupCostRepository.deleteById(id);
		else
			deleted = new StartupCost();
		return deleted;
	}

}
