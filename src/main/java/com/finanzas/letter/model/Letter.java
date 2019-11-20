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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;



@Data
@Entity
@Table(name = "letters")
public class Letter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="letter_id",unique=true)
	private Long id;
	
	@Column(name="nominal_value")
	private Double nominalValue;
	
	@Column(name = "retention")
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
	
	@Column(name="expiration_date")
	private LocalDate expirationDate;
	
	@Column(name="type_of_currency")
	private String typeOfCurrency;
	
	@ManyToOne(targetEntity = Portfolio.class,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "portfolio_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	//@JsonIgnore
    private Portfolio idPortfolio;
	
}
