package com.mms.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mms.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>
{

}

