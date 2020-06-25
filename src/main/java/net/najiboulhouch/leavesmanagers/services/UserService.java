package net.najiboulhouch.leavesmanagers.services;

import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;

import java.util.List;

import net.najiboulhouch.leavesmanagers.entities.User;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 */
public interface UserService {
	
	/**
	 * 
	 * @param name
	 * @return User
	 */
	public User findUserByName(String name);
	
	/**
	 * 
	 * @param user
	 * @param currentPassword
	 * @throws ValidationException
	 */
	public void saveUser(User user, String currentPassword) throws ValidationException;
	
	/**
	 * 
	 * @param user
	 * @param currentPassword
	 * @throws ValidationException
	 */
	public void changePassword(User user , String currentPassword) throws ValidationException;
	
	/**
	 * 
	 * @param user
	 * @param currentPassword
	 * @throws ValidationException
	 */
	public void deleteAccount(User user , String currentPassword) throws ValidationException;
	
	/**
	 * 
	 * @return list of Users
	 */
	public List<User> findUsersPendingRegistration();
	
	/**
	 * 
	 * @param user
	 * @throws ValidationException
	 */
	public void approveRegistration(User user) throws ValidationException;
	
	
	/**
	 * 
	 * @param user
	 * @throws ValidationException
	 */
	public void registerUser(User user) throws ValidationException;
}
