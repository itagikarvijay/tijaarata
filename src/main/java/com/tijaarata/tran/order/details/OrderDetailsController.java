/**
 * 
 */
package com.tijaarata.tran.order.details;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/orderDetails")
public class OrderDetailsController {
	
	@Autowired
	IOrderDetailsService orderDetailsService;

	@RequestMapping("/save")
	public void save(@RequestBody List<OrderDetailsDTO> orderDetailsDTO){
		UserInfo principal = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Principal "+principal.getUsername());
		orderDetailsService.saveAll(orderDetailsDTO);
	}
	
	@RequestMapping("/all")
	public List<OrderDetailsDTO> findAll(){
		 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        UserInfo user=null;
	        if (principal instanceof UserInfo) {
	        user = ((UserInfo)principal);
	        }
	        System.out.println("Principal "+user);
  		return orderDetailsService.findAll();
	}
}
