/**
 * 
 */
package com.tijaarata.master.customer;

import java.util.List;
import java.util.Optional;

import com.tijaarata.dto.BaseDTO;

/**
 * @author User
 *
 */
public interface ICustomerService {
	
	List<CustomerDTO> findAll();
	Optional<BaseDTO> getOne(Integer one);

}
