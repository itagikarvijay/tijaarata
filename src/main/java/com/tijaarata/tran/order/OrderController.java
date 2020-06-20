/**
 * 
 */
package com.tijaarata.tran.order;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tijaarata.master.user.UserInfo;

/**
 * @author User
 *
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	@RequestMapping("/order")
	public void save(@RequestBody List<OrderDTO> orderDTO){
		System.out.print(orderDTO);
		Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Principal "+principal);
		orderService.save(orderDTO);
	}
	
	@RequestMapping("/all")
	public List<OrderDTO> findAll(){
		 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        UserInfo user=null;
	        if (principal instanceof UserInfo) {
	        user = ((UserInfo)principal);
	        }
	        System.out.println("Principal "+user);
		return orderService.findAll();
	}

}
