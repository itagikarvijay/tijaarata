/**
 * 
 */
package com.tijaarata.tran.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tijaarata.mapper.MapperClz;
import com.tijaarata.master.customer.ICustomerRepo;
import com.tijaarata.tran.order.details.OrderDetails;

/**
 * @author User
 *
 */
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepo orderRepo;

	@Autowired
	ICustomerRepo customerRepo;

	@Autowired
	MapperClz<?> mapperClz;

	@Override
	public void save(List<OrderDTO> orderDTO) {
		orderRepo.saveAll(mapperClz.convertToEntity(orderDTO));
	}

	@Override
	public List<OrderDTO> findAll() {
		return mapperClz.convertToDto(orderRepo.findAll());
	}

}
