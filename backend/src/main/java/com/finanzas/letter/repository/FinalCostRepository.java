package com.finanzas.letter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.letter.model.FinalCost;
@Repository
public interface FinalCostRepository extends JpaRepository<FinalCost,Long> {

}
