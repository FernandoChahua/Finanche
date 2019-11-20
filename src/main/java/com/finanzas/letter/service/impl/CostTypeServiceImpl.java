package com.finanzas.letter.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.letter.model.CostType;
import com.finanzas.letter.repository.CostTypeRepository;
import com.finanzas.letter.service.CostTypeService;

@Service
public class CostTypeServiceImpl implements CostTypeService{

	@Autowired
	CostTypeRepository costTypeRepository;
	@Override
	@Transactional
	public CostType insertOrUpdate(CostType entity) {
		// TODO Auto-generated method stub
		return costTypeRepository.save(entity);
	}

	@Override
	public Optional<CostType> getOne(Long id) {
		// TODO Auto-generated method stub
		return costTypeRepository.findById(id);
	}

	@Override
	public List<CostType> getAll() {
		// TODO Auto-generated method stub
		return costTypeRepository.findAll();
	}

	@Override
	@Transactional
	public CostType delete(Long id) {
		// TODO Auto-generated method stub
		CostType deleted = costTypeRepository.findById(id).get();
		if(deleted != null) 
			costTypeRepository.deleteById(id);
		else
			deleted = new CostType();
		
		return deleted;
	}

}
