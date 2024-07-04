package com.mms.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BillDTO 
{
	
	@NotNull
	private int billId;
	
	@NotBlank
	@Size(min = 2,max=30,message = "Date is not valid")
	private String billDate;
	
	@NotNull
	private int amount;
	
}