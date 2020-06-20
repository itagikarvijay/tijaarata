package com.tijaarata.master.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tijaarata.dto.BaseDTO;
import com.tijaarata.exceptions.NotFoundException;
import com.tijaarata.mapper.MapperClz;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepo customerRepo;

	@Autowired
	MapperClz<?> mapperClz;

	@Override
	@Cacheable(cacheNames = "customersCache")
	public List<CustomerDTO> findAll() {
		return mapperClz.convertToDto(customerRepo.findAll());
	}

	@Override
	public Optional<BaseDTO> getOne(Integer one){
		Optional<Customer> customer = customerRepo.findById(one);
		if(!customer.isPresent())
			throw new NotFoundException("Customer not found.!");
		
		return mapperClz.convertToDto(customer);
	}

}
