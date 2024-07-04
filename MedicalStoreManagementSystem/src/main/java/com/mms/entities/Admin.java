package com.mms.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="Admin_details")
public class Admin
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Adminid",length =20)
	private int Id;
	
	@Column(name="Adminname",length =30)
	private String name;
	
	@Column(name="Adminpassword",length =50)
	private String password;
	
	@Column(name="Adminemail",length =50)
	private String email;
	
	@Column(name="Adminphno",length =30)
	private String phNo;
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("admin")
	private List<Customer> customers;
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("admin")
	private List<Medicines> medicines;
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("admin")
	private List<Supplier> suppliers;
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("admin")
	private List<Bill> bills;
}

