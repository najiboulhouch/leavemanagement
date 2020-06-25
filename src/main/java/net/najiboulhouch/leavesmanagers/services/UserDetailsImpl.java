package net.najiboulhouch.leavesmanagers.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import net.najiboulhouch.leavesmanagers.entities.Authority;
import net.najiboulhouch.leavesmanagers.entities.User;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see UserDetails
 */
public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private User user;
	private Set<Authority> authorities;

	public UserDetailsImpl(User user, Set<Authority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> sAuthorities = new ArrayList<>();
		for (Authority authority : authorities) {
			sAuthorities.add(new SimpleGrantedAuthority(authority.getCode()));
		}
		return sAuthorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		if (user.isEnabled())
			return true;
		else
			return false;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

}
