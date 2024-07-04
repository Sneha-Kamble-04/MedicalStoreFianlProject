package com.mms.utility;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import com.mms.entities.Admin;
import com.mms.model.AdminDTO;

@Component
public class AdminConverter 
{
	//convert DTO to Entity
	public Admin convertToAdminEntity(AdminDTO adminDTO)
	{
		Admin admin=new Admin();
		if(adminDTO!=null)
		{
			BeanUtils.copyProperties(adminDTO, admin);
		}
		return admin;
	}
	
	//Convert Entity to DTO
	public AdminDTO convertToAdminDTO(Admin  admin)
	{
		AdminDTO adminDTO=new AdminDTO();
		if(admin!=null)
		{
			BeanUtils.copyProperties(admin, adminDTO);
		}
		return adminDTO;
	}

}
