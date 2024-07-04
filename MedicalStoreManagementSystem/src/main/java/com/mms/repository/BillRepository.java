package com.mms.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mms.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>
{

}