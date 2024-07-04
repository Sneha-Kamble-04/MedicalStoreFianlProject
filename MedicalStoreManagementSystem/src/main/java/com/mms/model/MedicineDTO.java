package com.mms.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Setter
@Getter
@ToString
public class MedicineDTO 
{
	@NotNull
	private int Id;
	
	@NotBlank
	@Size(min = 2,max = 20, message = "Name should contain only min 2 to max 20 character")
	private String name;
	
	@NotNull
	private float price;
	
	@NotNull
	private int quantity;
	
	@NotBlank
	private String manufacturingdate;
	
	@NotBlank
	private String expirydate;

}
