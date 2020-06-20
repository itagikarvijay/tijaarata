package com.tijaarata.master.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer,Integer>  {

}
