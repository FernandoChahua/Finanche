package com.finanzas.letter.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.letter.model.FinalCost;
import com.finanzas.letter.repository.FinalCostRepository;
import com.finanzas.letter.service.FinalCostService;

@Service
public class FinalCostServiceImpl implements FinalCostService{

	@Autowired
	FinalCostRepository finalCostRepository;
	
	@Transactional
	@Override
	public FinalCost insertOrUpdate(FinalCost entity) {
		// TODO Auto-generated method stub
		return finalCostRepository.save(entity);
	}

	@Override
	public Optional<FinalCost> getOne(Long id) {
		// TODO Auto-generated method stub
		return finalCostRepository.findById(id);
	}

	@Override
	public List<FinalCost> getAll() {
		// TODO Auto-generated method stub
		return finalCostRepository.findAll();
	}

	@Override
	@Transactional
	public FinalCost delete(Long id) {
		// TODO Auto-generated method stub
		FinalCost deleted = finalCostRepository.findById(id).get();
		
		if(deleted != null)
			finalCostRepository.deleteById(id);
		else
			deleted = new FinalCost();
		
		return deleted;
	}

}
