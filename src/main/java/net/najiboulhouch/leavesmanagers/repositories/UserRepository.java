package net.najiboulhouch.leavesmanagers.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.najiboulhouch.leavesmanagers.entities.User;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 20/12/2018
 * @see CrudRepository
 */
public interface UserRepository extends CrudRepository<User , String> {

	public User findByUserName(String name);
	public List<User> findByEnabledFalse();
	
	
}
