package com.mms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mms.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>
{

}
