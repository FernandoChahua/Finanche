package com.finanzas.letter.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.letter.model.Letter;
import com.finanzas.letter.repository.LetterRepository;
import com.finanzas.letter.service.LetterService;
@Service
public class LetterServiceImpl implements LetterService{

	@Autowired
	LetterRepository letterRepository;
	
	@Transactional
	@Override
	public Letter insertOrUpdate(Letter entity) {
		// TODO Auto-generated method stub
		return letterRepository.save(entity);
	}

	@Override
	public Optional<Letter> getOne(Long id) {
		// TODO Auto-generated method stub
		return letterRepository.findById(id);
	}

	@Override
	public List<Letter> getAll() {
		// TODO Auto-generated method stub
		return letterRepository.findAll();
	}

	@Override
	@Transactional
	public Letter delete(Long id) {
		// TODO Auto-generated method stub
		Letter deleted = letterRepository.findById(id).get();
		
		if(deleted != null)
			letterRepository.deleteById(id);
		else
			deleted = new Letter();
		return null;
		
	}
	

}
