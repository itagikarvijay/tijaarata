/**
 * 
 */
package com.tijaarata.master.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tijaarata.mapper.MapperClz;

/**
 * @author User
 *
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	MapperClz<?> mapperClz;

	@Autowired
	IUserService userService;

	@GetMapping("/authenticateUser")
	public UserInfo getUser(HttpServletRequest req) {
		org.springframework.security.core.userdetails.User principal = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		System.out.println("Authentication");
		System.out.println(principal);

		HttpSession session = req.getSession();

		UserInfo uf = (UserInfo) session.getAttribute("userInfo");

		if (uf == null) {
			UserInfo user = userService.authenticate(principal);
			session.setAttribute("userInfo", user);
		}

		return (UserInfo) session.getAttribute("userInfo");
	}

	@GetMapping("/all")
	public List<UserInfo> getAll() {
		return userService.getAll();
	}

	@PostMapping("/logout")
	public void sessopnExpired(HttpServletRequest req) {
		System.out.println("Session expired");
		req.getSession().invalidate();
	}

	@PostMapping("/invalidateSessionUrl")
	public void invalidateSessopnExpired(HttpServletRequest req) {
		System.out.println("Session expired");
		req.getSession().invalidate();
	}

}
