/**
 * 
 */
package com.tijaarata.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tijaarata.dto.BaseDTO;
import com.tijaarata.entity.BaseEntity;
import com.tijaarata.master.category.CategoryDTO;
import com.tijaarata.master.customer.CustomerDTO;
import com.tijaarata.master.product.ProductDTO;
import com.tijaarata.master.user.User;
import com.tijaarata.master.user.UserInfo;
import com.tijaarata.tran.order.Order;
import com.tijaarata.tran.order.OrderDTO;
import com.tijaarata.tran.order.details.OrderDetails;
import com.tijaarata.tran.order.details.OrderDetailsDTO;

/**
 * @author User
 * @param <R>
 *
 */

@Component
public class MapperClz<R> {

	@Autowired
	private ModelMapper modelMapper;

	@SuppressWarnings("unchecked")
	public <T> List<T> convertToDto(List<? extends BaseEntity> entity) {
		System.out.println(entity);
		List<T> list = new ArrayList<T>();
		for (BaseEntity e : entity) {
			if (e.getClass().getName().equals("com.tijaarata.master.category.CategoryEntity")) {
				list.add((T) modelMapper.map(e, CategoryDTO.class));
			}
			if (e.getClass().getName().equals("com.tijaarata.master.product.Product")) {
				list.add((T) modelMapper.map(e, ProductDTO.class));
			}
			if (e.getClass().getName().equals("com.tijaarata.master.customer.Customer")) {
				list.add((T) modelMapper.map(e, CustomerDTO.class));
			}
			if (e.getClass().getName().equals("com.tijaarata.tran.order.details.OrderDetails")) {
				list.add((T) modelMapper.map(e, OrderDetailsDTO.class));
			}
			if (e.getClass().getName().equals("com.tijaarata.tran.order.Order")) {
				list.add((T) modelMapper.map(e, OrderDTO.class));
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public <T> Optional<BaseDTO> convertToDto(T entity) throws RuntimeException {
		Optional<?> t = null;
		entity = (T) ((Optional<?>) entity).get();
		if (entity.getClass().getName().equals("com.tijaarata.master.customer.Customer")) {
//				return (Optional<BaseDTO>) Optional.of(((T) modelMapper.map(entity, CustomerDTO.class)));
			t = Optional.of(((T) modelMapper.map(entity, CustomerDTO.class)));
		}
		return (Optional<BaseDTO>) t;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> convertToEntity(List<? extends BaseDTO> dto) {
		System.out.println(dto);
		List<T> list = new ArrayList<T>();
		for (BaseDTO e : dto) {
			if (e.getClass().getName().equals("com.tijaarata.tran.order.details.OrderDetailsDTO")) {
				list.add((T) modelMapper.map(e, OrderDetails.class));
			}
			if (e.getClass().getName().equals("com.tijaarata.tran.order.OrderDTO")) {
				T order = (T) modelMapper.map(e, Order.class);
				for (OrderDetails o : ((Order) order).getOrderDetails()) {
					o.setOrder((Order) order);
				}
				list.add(order);
			}
		}
		return list;
	}

	public UserInfo convertToUserInfo(User user) {
		UserInfo userInfo = null;
		if (Optional.of(user).isPresent()) {
			userInfo = new UserInfo();
			userInfo.setId(user.getId());
			userInfo.setUsername(user.getName());
			userInfo.setPassword(user.getPassword());
			userInfo.setEmail("abc@gmail.com");
			userInfo.setFirstName(user.getCustomer().getName());
			userInfo.setRoles(user.getRoles());
		}
		if (userInfo == null) {
			throw new RuntimeException("User not valid.!");
		} else {
			return userInfo;
		}
	}

	public List<UserInfo> convertToUserInfo(List<User> user) {
		List<UserInfo> userInfoList = new ArrayList<UserInfo>();
		for (User u : user)
			if (Optional.of(user).isPresent()) {
				UserInfo userInfo = new UserInfo();
				userInfo.setId(u.getId());
				userInfo.setUsername(u.getName());
				userInfo.setEmail("abc@gmail.com");
				userInfo.setFirstName(u.getCustomer().getName());
				userInfo.setPassword(u.getPassword());
				userInfo.setRoles(u.getRoles());
				userInfoList.add(userInfo);
			}
		if (userInfoList.size() == 0) {
			throw new RuntimeException("Users not found.!");
		} else {
			return userInfoList;
		}
	}
}
