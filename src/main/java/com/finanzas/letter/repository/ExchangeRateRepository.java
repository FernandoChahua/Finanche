package com.finanzas.letter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.letter.model.ExchangeRate;
@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long>{

}
