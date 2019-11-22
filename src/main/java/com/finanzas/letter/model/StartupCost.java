package com.finanzas.letter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="startup_costs")


public class StartupCost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="startup_cost_id")
	private Long id;
	
	@Column(name = "amount_reason")
	private Double amountReason;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name = "type_cost")
	private String typeCost;
	
	@ManyToOne(targetEntity = Letter.class,fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "letter_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Letter letter;
	
	@Column(name = "letter_id")
	private Long idLetter;
	
	
	
}
