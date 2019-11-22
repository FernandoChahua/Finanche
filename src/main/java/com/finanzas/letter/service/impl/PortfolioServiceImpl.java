package com.finanzas.letter.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.letter.model.Letter;
import com.finanzas.letter.model.Portfolio;
import com.finanzas.letter.repository.LetterRepository;
import com.finanzas.letter.repository.PortfolioRepository;
import com.finanzas.letter.service.PortfolioService;
import com.finanzas.letter.util.OperationDate;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	PortfolioRepository portfolioRepository;
	@Autowired
	LetterRepository letterRepository;

	@Transactional
	@Override
	public Portfolio insertOrUpdate(Portfolio entity) {
		// TODO Auto-generated method stub

		return portfolioRepository.save(entity);
	}

	@Override
	public Portfolio getOne(Long id) {
		// TODO Auto-generated method stub

		Portfolio entity = portfolioRepository.findById(id).orElse(null);
		if (entity != null) {
			List<Letter> letters = entity.getLetters();

			double tcea = 0;
			double totalReceived = 0;

			if (letters != null) {
				for (Letter l : letters) {
					l = letterRepository.save(l);
					totalReceived = OperationDate.setPrecision(totalReceived + l.getReceivedValue(), 2);
				}
			}
			entity.setLetters(letters);
			entity.setTotalReceive(totalReceived);
			if (letters.size() == 1) {
				tcea = letters.get(0).getTcea();
			} else {
				tcea = TIR(entity);
			}

			entity.setTceaPortfolio(tcea);

		}
		entity = portfolioRepository.save(entity);
		return entity;
	}

	@Override
	public List<Portfolio> getAll() {
		// TODO Auto-generated method stub
		return portfolioRepository.findAll();
	}

	@Override
	@Transactional
	public Portfolio delete(Long id) {
		// TODO Auto-generated method stub
		Portfolio deleted = portfolioRepository.findById(id).get();
		if (deleted != null)
			portfolioRepository.deleteById(id);
		else
			deleted = new Portfolio();
		return deleted;

	}

	public Double TIR(Portfolio p) {

		List<Letter> letters = letterRepository.findAllByIdPortfolio(p.getId());
		double TIR = 0;
		double previo = 0;
		double nuevo = 0;
		double prevRatio = 0.001;
		double nuevoRatio = 0.001;
		double ratio = 0.001;
		double ratioMIN = 0.0001;
		double ratioMAX = 1.0000;
		double van = 0;
		double denominador = 0;
		double precisionSolicitada = 0.0001;
		double maxIteraciones = 100000;
		int i = 0;
		while (i < maxIteraciones || (van > 0 && van < precisionSolicitada)) {
			van = -p.getTotalReceive();
			for (int j = 0; j < letters.size(); j++) {
				denominador = OperationDate.setPrecision(Math.pow(1 + ratio,
						Double.valueOf(OperationDate.restaDate(p.getDiscountDate(), letters.get(j).getExpirationDate()))
								/ Double.valueOf(p.getDaysPerYear())),
						2);
				van = OperationDate.setPrecision(
						van + OperationDate.setPrecision(letters.get(j).getDeliveredValue() / denominador, 2), 2);

			}
			if (previo == 0) {
				previo = van;
			} else {
				previo = nuevo;
			}
			nuevo = van;
			if (i > 0) {
				if (previo < nuevo) {
					if (previo < 0 && nuevo < 0) {
						ratioMAX = nuevoRatio;
					} else {
						ratioMIN = nuevoRatio;
					}
				} else {
					if (previo > 0 && nuevo > 0) {
						ratioMIN = nuevoRatio;
					} else {
						ratioMAX = nuevoRatio;
					}
				}
			}
			prevRatio = ratio;
			ratio = OperationDate.setPrecision(Double.valueOf(ratioMIN + ratioMAX) / 2.00, 7);
			nuevoRatio = ratio;
			i = i + 1;
		}
		TIR = OperationDate.setPrecision(ratio, 7);
		return TIR;
	}
}
