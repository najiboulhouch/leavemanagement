package net.najiboulhouch.leavesmanagers.services;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import net.najiboulhouch.leavesmanagers.entities.User;
import net.najiboulhouch.leavesmanagers.repositories.UserRepository;

/**
 * Allow all users to connect to application trough this class.
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see UserDetailsService
 */

@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

	@Inject
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findOne(username);
		UserDetailsImpl userDetails = null;
		if (user != null) {
			if (!user.isEnabled()) {
				throw new UsernameNotFoundException("Your account is disabled.");
			} else {
				userDetails = new UserDetailsImpl(user, user.getGroupe().getAuthorities());
			}
		} else {
			throw new UsernameNotFoundException("The requested user not registered.");
		}
		return userDetails;
	}

}
