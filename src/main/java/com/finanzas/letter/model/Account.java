package com.finanzas.letter.model;

import java.util.Date;
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


@Entity
@Table(name = "users")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	
	@Column(name = "account_status")
	private int account_status;

	@Column(name = "email", unique = true, length = 100)
	private String email;
	
	@Column
	private Boolean email_validated;
	
	@Column(name = "first_name", length = 20)
	private String first_name;

	@Column(name = "last_name", length = 20)
	private String last_name;


	@Column(length = 30)
	private String password;

	@Column(name = "register_date")
	private Date register_date;
	
	@Column(name = "username", unique = true, length = 20)
	private String username;
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "user_id", "role_id" }) })
	private List<Role> roles;

}
