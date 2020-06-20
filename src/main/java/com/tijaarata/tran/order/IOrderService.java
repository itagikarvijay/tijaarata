package com.tijaarata.tran.order;

import java.util.List;

public interface IOrderService {
	
	void save(List<OrderDTO> orderDTO);
	List<OrderDTO> findAll();

}
