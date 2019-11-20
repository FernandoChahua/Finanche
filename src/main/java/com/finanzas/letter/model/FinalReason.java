package com.finanzas.letter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "final_reasons")
public class FinalReason {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="final_reason_id")
	private Long id;
	
	@Column(name = "description")
	private String description;

}
