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

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name="final_costs")
@Entity

public class FinalCost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="final_cost_id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "amount_reason")
	private Double amountReason;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "final_reason_id", nullable = false)
    //@JsonIgnore
    private FinalReason finalReason;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cost_type_id", nullable = false)
    //@JsonIgnore
    private CostType costType;
	
	@ManyToOne(targetEntity = Letter.class,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "letter_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private Long idLetter;
}
