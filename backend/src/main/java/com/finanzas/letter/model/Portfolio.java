package com.finanzas.letter.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
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
	private String name;//
	
	@Column(name="discount_date")
	public	LocalDate discountDate;//
	
	@Column(name="days_per_year")
	private Integer daysPerYear;//
	
	@Column(name="tea")
	private Double tea;//
	
	@Column(name="tcea_portfolio")
	private Double tceaPortfolio;
	
	@Column(name="total_receive")
	private Double totalReceive;
	
	@Column(name="type_of_currency")
	private String typeOfCurrency;//
	
	@Column(name = "exchange_rate")
	private Double exchangeRate;
	
	@OneToMany(cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.MERGE }, orphanRemoval = true)
	@JoinColumn(name = "portfolio_id", insertable = false, updatable = false)
	private List<Letter> letters;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Account.class,fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private Account user;	
	
	@Column(name="user_id")
	private Long idUser;
	
}
