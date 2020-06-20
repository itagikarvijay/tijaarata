/**
 * 
 */
package com.tijaarata.master.customer;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tijaarata.dto.BaseDTO;

/**
 * @author User
 *
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	ICustomerService customerService;

	@RequestMapping("/customers")
	public List<CustomerDTO> getAll() {
		return customerService.findAll();
	}

	@RequestMapping("/one/{id}")
	public ResponseEntity<CustomerDTO> getOne(@PathVariable("id") Integer id) {
	
		CustomerDTO customerDTO = null;
		Optional<BaseDTO> customerDto = customerService.getOne(id);
		if (customerDto.isPresent()) {
			customerDTO = (CustomerDTO) customerDto.get();
		}
		return new ResponseEntity<>(customerDTO, HttpStatus.OK);
	}
}
