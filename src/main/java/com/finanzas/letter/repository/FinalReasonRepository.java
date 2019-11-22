package com.finanzas.letter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.letter.model.FinalReason;

@Repository
public interface FinalReasonRepository extends JpaRepository<FinalReason, Long>{

}
