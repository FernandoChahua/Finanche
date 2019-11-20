package com.finanzas.letter.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.letter.model.Role;
import com.finanzas.letter.repository.RoleRepository;
import com.finanzas.letter.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Transactional
	@Override
	public Role insertOrUpdate(Role entity) {
		// TODO Auto-generated method stub
		return roleRepository.save(entity);
	}

	@Override
	public Optional<Role> getOne(Long id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id);
	}

	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	@Transactional
	public Role delete(Long id) {
		// TODO Auto-generated method stub
		Role deleted = roleRepository.findById(id).get();
		if(deleted != null)
			roleRepository.deleteById(id);
		else
			deleted = new Role();
		return deleted;
	}

}
