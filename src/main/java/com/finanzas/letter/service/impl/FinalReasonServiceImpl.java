package com.finanzas.letter.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.letter.model.FinalReason;
import com.finanzas.letter.repository.FinalReasonRepository;
import com.finanzas.letter.service.FinalReasonService;

@Service
public class FinalReasonServiceImpl implements FinalReasonService{

	@Autowired
	FinalReasonRepository finalReasonRepository;
	
	@Transactional
	@Override
	public FinalReason insertOrUpdate(FinalReason entity) {
		// TODO Auto-generated method stub
		return finalReasonRepository.save(entity);
	}

	@Override
	public Optional<FinalReason> getOne(Long id) {
		// TODO Auto-generated method stub
		return finalReasonRepository.findById(id);
	}

	@Override
	public List<FinalReason> getAll() {
		// TODO Auto-generated method stub
		return finalReasonRepository.findAll();
	}

	@Override
	@Transactional
	public FinalReason delete(Long id) {
		// TODO Auto-generated method stub
		FinalReason deleted = finalReasonRepository.findById(id).get();
		
		if(deleted != null)
			finalReasonRepository.deleteById(id);
		else
			deleted = new FinalReason();
		
		return deleted;
		
	}

}
