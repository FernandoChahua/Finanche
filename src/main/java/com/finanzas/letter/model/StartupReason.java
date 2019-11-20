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
@Table(name="startup_reasons")
public class StartupReason {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="startup_reason_id")
	private Long id;
	
	@Column(name = "description")
	private String description;
	
}
