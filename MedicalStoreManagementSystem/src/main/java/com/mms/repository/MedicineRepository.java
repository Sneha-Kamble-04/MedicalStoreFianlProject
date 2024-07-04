package com.mms.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mms.entities.Medicines;
public interface MedicineRepository extends JpaRepository<Medicines,Integer>
{

}
