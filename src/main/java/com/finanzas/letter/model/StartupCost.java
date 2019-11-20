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
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "amount_reason")
	private Double amountReason;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "startup_reason_id", nullable = false)
    //@JsonIgnore
    private StartupReason startupReason;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cost_type_id", nullable = false)
    //@JsonIgnore
    private CostType costType;
	
	@ManyToOne(targetEntity = Letter.class,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "letter_id", nullable = false)
    //@JsonIgnore
    private Long idLetter;
	
	
	
}
