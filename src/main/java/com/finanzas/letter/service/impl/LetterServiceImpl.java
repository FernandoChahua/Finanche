package com.finanzas.letter.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.letter.model.FinalCost;
import com.finanzas.letter.model.Letter;
import com.finanzas.letter.model.Portfolio;
import com.finanzas.letter.model.StartupCost;
import com.finanzas.letter.repository.LetterRepository;
import com.finanzas.letter.repository.PortfolioRepository;
import com.finanzas.letter.service.LetterService;
import com.finanzas.letter.util.OperationDate;
@Service
public class LetterServiceImpl implements LetterService{

	@Autowired
	LetterRepository letterRepository;
	@Autowired
	PortfolioRepository portfolioRepository;
	
	@Transactional
	@Override
	public Letter insertOrUpdate(Letter entity) {
		double totalStartupCost = 0;
		double totalFinalCost = 0;
		double nethWorth = 0;
		double deliveredValue = 0;
		double discountRate = 0;
		double receivedValue = 0;
		double tcea = 0;
		double discountValue = 0;

		Portfolio p = portfolioRepository.findById(entity.getIdPortfolio()).get();
		entity.setPortfolio(p);
		if(entity.getFinalCosts() != null) {
			for(FinalCost f : entity.getFinalCosts()) {
				f.setLetter(entity);
				f.setIdLetter(entity.getId());
				totalFinalCost = OperationDate.setPrecision(totalFinalCost + ((f.getTypeCost().equals("P"))?f.getAmountReason()*entity.getNominalValue():f.getAmountReason()),2);
			}
		}
		
		if(entity.getStartupCosts() != null) {
			for(StartupCost s : entity.getStartupCosts()) {
				s.setLetter(entity);
				s.setIdLetter(entity.getId());
				totalStartupCost = OperationDate.setPrecision(totalStartupCost + OperationDate.setPrecision(((s.getTypeCost().equals("P"))?s.getAmountReason()*entity.getNominalValue():s.getAmountReason()),2),2);
			}
		}
		
		long diffDays = OperationDate.restaDate(entity.getPortfolio().getDiscountDate(), entity.getExpirationDate());
		double tep = OperationDate.setPrecision(Math.pow(1+p.getTea(),Double.valueOf(diffDays)/Double.valueOf(360))-1, 7);
		discountRate = OperationDate.setPrecision(tep / (Double.valueOf(1)+tep), 7);
		discountValue = OperationDate.setPrecision(discountRate * entity.getNominalValue(),2);
		nethWorth = OperationDate.setPrecision(entity.getNominalValue() - discountValue,2);
		receivedValue = OperationDate.setPrecision(nethWorth - totalStartupCost - entity.getRetention(),2);
		deliveredValue = OperationDate.setPrecision(entity.getNominalValue() + totalFinalCost - entity.getRetention(),2);
		tcea = OperationDate.setPrecision(Math.pow(deliveredValue/receivedValue, Double.valueOf(360)/Double.valueOf(diffDays)) - 1,7);
		
		entity.setDeliveredValue(deliveredValue);
		entity.setDiscountRate(discountRate);
		entity.setDiscountValue(discountValue);
		entity.setNetWorth(nethWorth);
		entity.setReceivedValue(receivedValue);
		entity.setTcea(tcea);
		entity.setTotalFinalCost(totalFinalCost);
		entity.setTotalStartupCost(totalStartupCost);
		
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
