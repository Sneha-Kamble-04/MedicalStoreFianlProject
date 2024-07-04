package com.mms.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mms.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer>
{

}

