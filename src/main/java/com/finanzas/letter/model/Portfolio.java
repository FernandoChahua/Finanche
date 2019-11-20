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
@Table(name="portfolios")
public class Portfolio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="portfolio_id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="discount_date")
	public	LocalDate discountDate;
	
	@Column(name="days_per_year")
	private Integer daysPerYear;
	
	@Column(name="tea")
	private Double tea;
	
	@Column(name="tcea_portfolio")
	private Double tceaPortfolio;
	
	@Column(name="total_receive")
	private Double totalReceive;
	
	@Column(name="type_of_currency")
	private String typeOfCurrency;
	
	@ManyToOne(targetEntity = Account.class,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	//@JsonIgnore
    private Account idUser;	
}
