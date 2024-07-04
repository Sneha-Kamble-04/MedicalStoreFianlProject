package com.mms.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Setter
@Getter
@ToString
public class CustomerDTO
{
	@NotNull
	private int Id;
	
	@NotBlank
	@Size(min = 2,max = 20, message = "Name should contain only min 2 to max 20 character")
	private String name;
	
	@NotBlank
	@Size(min = 4,max = 20, message = "Address should contain only min 2 to max 30 character")
	private String address;
	
	@Email
	@Size(min=2,max=30,message = "Email id is not valid")
	private String email;
	
	@NotBlank
	@Size(min=10,max=10,message="Mobile must be only 10 digits")
	private String phNo;

}
