package com.mms.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mms.entities.Admin;
import com.mms.service.AdminService;
import com.mms.model.AdminDTO;

import jakarta.validation.Valid;
import com.mms.utility.AdminConverter;


@RestController
@Validated
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	AdminConverter adminconverter;
	
	@PostMapping("/api/createAdmin")
	ResponseEntity<AdminDTO> createAdmin(@Valid @RequestBody AdminDTO admindto )
	{
		final Admin admin=adminconverter.convertToAdminEntity(admindto);
		return new ResponseEntity<AdminDTO>(adminService.createAdmin(admin),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/getAdmin")
	List<AdminDTO> getAdmin()
	{
		return adminService.getAdmin();		
	}
	
	@PutMapping("/api/updateAdmin/{aid}")
	AdminDTO updateAdmin(@Valid @PathVariable("aid") int id,@RequestBody Admin admin)
	{
		return adminService.updateAdmin(id, admin);
		
	}

}
