package com.finanzas.letter.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Data;
import java.util.List;


@Data
@Entity
@Table(name = "letters")
public class Letter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="letter_id",unique=true)
	private Long id;
	
	@Column(name="nominal_value") // recibo
	private Double nominalValue;
	
	@Column(name = "retention") // recibo
	private Double retention;
	
	@Column(name = "net_worth") 
	private Double netWorth;
	
	@Column(name = "delivered_value") 
	private Double deliveredValue;
	
	@Column(name="received_value")
	private Double receivedValue;
	
	@Column(name="discount_value")
	private Double discountValue;
	
	@Column(name="tcea")
	private Double tcea;
	
	@Column(name="discount_rate")
	private Double discountRate;
	
	@Column(name = "total_final_cost")
	private Double totalFinalCost;
	
	@Column(name = "total_startup_cost")
	private Double totalStartupCost;
	
	@Column(name="expiration_date")
	private LocalDate expirationDate; // recibo
	
	@Column(name="type_of_currency")
	private String typeOfCurrency; // recibo
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Portfolio.class,fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "portfolio_id", nullable = false, insertable = false, updatable = false)
    private Portfolio portfolio;	
	
	@Column(name="portfolio_id")
	private Long idPortfolio;
	
	@OneToMany(cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.MERGE }, orphanRemoval = true)
	@JoinColumn(name = "letter_id", insertable = false, updatable = false)
	private List<StartupCost> startupCosts; // recibo
	
	@OneToMany(cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.MERGE }, orphanRemoval = true)
	@JoinColumn(name = "letter_id", insertable = false, updatable = false)
	private List<FinalCost> finalCosts; // recibo
	
}
