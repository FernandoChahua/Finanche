package com.finanzas.letter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.letter.model.CostType;

@Repository
public interface CostTypeRepository extends JpaRepository<CostType, Long> {

}
