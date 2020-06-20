/**
 * 
 */
package com.tijaarata.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import com.tijaarata.master.role.Role;
import com.tijaarata.master.user.IUserRepo;
import com.tijaarata.master.user.User;

/**
 * @author User
 *
 */
@Component
public class AuthManager implements AuthenticationProvider {

	@Autowired
	IUserRepo userRepo;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		User user = userRepo.findByName(username);

		if (user == null || !user.getName().equalsIgnoreCase(username)) {
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals(user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}

//		 if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
//			 throw new BadCredentialsException("Wrong password");
//		 }

		return new UsernamePasswordAuthenticationToken(
				new org.springframework.security.core.userdetails.User(username, password, getAuthorities(user)),
				password, getAuthorities(user));
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	private Collection<? extends GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			SimpleGrantedAuthority s = new SimpleGrantedAuthority("ROLE_" + role.getRole());
			authorities.add(s);
		}
		return authorities;
	}
}
