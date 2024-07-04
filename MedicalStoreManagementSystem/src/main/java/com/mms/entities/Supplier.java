package com.mms.entities;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@SQLDelete(sql = "update supplier_details set status=true where id=?")
@Where(clause =  "status=false")
@Entity
@Table(name="supplier_details")
public class Supplier 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="supplierid",length =20)
	private int Id;
	
	private boolean status=Boolean.FALSE;
	
	@Column(name="suppliername",length =30)
	private String name;
	
	@Column(name="supplieradd",length =50)
	private String address;
	
	@Column(name="suppliermail",length =50)
	private String email;
	
	@Column(name="supplierphno",length =30)
	private String phNo;
	
	@OneToMany(mappedBy="supplier",cascade = CascadeType.PERSIST)
	private List<Medicines> medicines;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("supplier")
	private Bill bill;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="admin")
	@JsonIgnoreProperties("suppliers")
	private Admin admin;
}

