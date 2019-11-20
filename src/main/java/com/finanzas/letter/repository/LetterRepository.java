package com.finanzas.letter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.letter.model.Letter;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Long> {
	List<Letter> findAllByIdPortfolio(Long id);
}
