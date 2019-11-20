package com.finanzas.letter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.letter.model.StartupCost;

@Repository
public interface StartupCostRepository extends JpaRepository<StartupCost, Long>{

}
