/**
 * 
 */
package com.tijaarata.tran.order.details;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tijaarata.mapper.MapperClz;

/**
 * @author User
 *
 */
@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService {
	
	@Autowired
	IOrderDetailsRepo orderDetailsRepo;
	
	@Autowired
	MapperClz<?> mapperClz;

	@Override
	public void saveAll(List<OrderDetailsDTO> orderDetailsDTO) {
		orderDetailsRepo.saveAll(mapperClz.convertToEntity(orderDetailsDTO));
	}

	@Override
	public List<OrderDetailsDTO> findAll() {
		return mapperClz.convertToDto(orderDetailsRepo.findAll());
	}

}
