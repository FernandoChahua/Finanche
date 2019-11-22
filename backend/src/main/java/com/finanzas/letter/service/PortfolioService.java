package com.finanzas.letter.service;

import java.util.List;

import com.finanzas.letter.model.Portfolio;

public interface PortfolioService extends CrudService<Portfolio>{
	List<Portfolio> findByUserId(Long id);
}
