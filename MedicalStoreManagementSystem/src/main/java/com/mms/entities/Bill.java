package com.mms.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "BillInformation")
public class Bill 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 30)
	private int billId;
	
	@Column(length = 30)
	private String billDate;

	@Column(length = 30)
	private int amount;
	
	@OneToMany(mappedBy="bill",cascade = CascadeType.PERSIST)
	private List<Customer> customer;
	
	@OneToMany(mappedBy="bill",cascade = CascadeType.PERSIST)
	private List<Supplier> supplier;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="admin")
	@JsonIgnoreProperties("bills")
	private Admin admin;
}