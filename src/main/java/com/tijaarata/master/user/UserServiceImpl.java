/**
 * 
 */
package com.tijaarata.master.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tijaarata.mapper.MapperClz;

/**
 * @author User
 *
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepo userRepo;
	
	@Autowired
	MapperClz<?> mapperClz;
	
	@Autowired
	IUserService userService;

	@Override
	public UserInfo authenticate(org.springframework.security.core.userdetails.User principal) {
		;
		return mapperClz.convertToUserInfo(userRepo.findByName(principal.getUsername()));
	}

	@Override
	public List<UserInfo> getAll() {
		return mapperClz.convertToUserInfo(userRepo.findAll());
	}

}
