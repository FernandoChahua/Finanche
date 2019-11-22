package com.finanzas.letter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.letter.model.StartupReason;

@Repository
public interface StartupReasonRepository extends JpaRepository<StartupReason, Long>{

}
