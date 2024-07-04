package com.mms.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="medicine_details")
public class Medicines 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="medicineid",length =20)
	private int Id;
	
	@Column(name="MedicineName",length =30)
	private String name;
	
	@Column(name="MedicinePrice",length =50)
	private float price;
	
	@Column(name="MedicineQuantity",length =50)
	private int quantity;
	
	@Column(name="MedicineManufacturingDate",length =30)
	private String manufacturingdate;
	
	@Column(name="MedicineExpiryDate",length =30)
	private String expirydate;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("medicines")
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("medicines")
	private Supplier supplier;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="admin")
	@JsonIgnoreProperties("medicines")
	private Admin admin;
	
	
}

