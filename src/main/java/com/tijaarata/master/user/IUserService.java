/**
 * 
 */
package com.tijaarata.master.user;

import java.util.List;

/**
 * @author User
 *
 */
public interface IUserService {

	UserInfo authenticate(org.springframework.security.core.userdetails.User user);

	List<UserInfo> getAll();

}
