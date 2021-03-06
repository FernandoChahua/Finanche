package com.finanzas.letter.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	
	@Column(name = "account_status")
	private int accountStatus;

	@Column(name = "email", unique = true, length = 100)
	private String email;
	
	@Column
	private Boolean emailValidated;
	
	@Column(name = "first_name", length = 20)
	private String firstName;

	@Column(name = "last_name", length = 20)
	private String lastName;


	@Column(name = "password")
	private String password;

	@Column(name = "register_date")
	private LocalDate registerDate;
	
	@Column(name = "username", unique = true, length = 20)
	private String username;
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "user_id", "role_id" }) })
	private List<Role> roles;

}
