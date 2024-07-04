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

@SQLDelete(sql = "update customer_details set status=true where id=?")
@Where(clause =  "status=false")

@Entity
@Table(name="customer_details")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="custid",length =20)
	private int Id;
	
	private boolean status=Boolean.FALSE;
	
	@Column(name="custname",length =30)
	private String name;
	
	@Column(name="custadd",length =50)
	private String address;
	
	@Column(name="custemail",length =50)
	private String email;
	
	@Column(name="custphno",length =30)
	private String phNo;
	
	@OneToMany(mappedBy="customer",cascade = CascadeType.PERSIST)
	private List<Medicines> medicines;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("customer")
	private Bill bill;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="admin")
	@JsonIgnoreProperties("customers")
	private Admin admin;
}

