package com.tijaarata.tran.order.details;

import java.util.List;

public interface IOrderDetailsService {
	
	void saveAll(List<OrderDetailsDTO> orderDTO);
	List<OrderDetailsDTO> findAll();

}
