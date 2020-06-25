package net.najiboulhouch.leavesmanagers.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import net.najiboulhouch.leavesmanagers.entities.Title;
import net.najiboulhouch.leavesmanagers.entities.User;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;
import net.najiboulhouch.leavesmanagers.services.UserService;
import net.najiboulhouch.leavesmanagers.utils.Filesi18n;
import net.najiboulhouch.leavesmanagers.utils.MessagesUtils;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 */
@Named
@Scope("view")
public class RegistrationController {

	@Inject private UserService userService;
	private List<User> users ;
	private Title[] title;
	private User user ;
	
	@PostConstruct
	private void init() {
		users = userService.findUsersPendingRegistration();
		title = Title.values();
		user = new User();
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Title[] getTitle() {
		return title;
	}

	public void setTitle(Title[] title) {
		this.title = title;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 
	 * @param user
	 */
	public void approveRegistration(User user){
		try {
			userService.approveRegistration(user);
			this.init();
			MessagesUtils.addMessages(Filesi18n.readMessageFromFile("ACTION.USER.REGISTRATION.APPROVE.SUCCESS"), FacesMessage.SEVERITY_INFO);
		} catch (ValidationException exception) {
			MessagesUtils.addMessages(exception.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void register(){
		try {
			userService.registerUser(user);
			MessagesUtils.addMessages(Filesi18n.readMessageFromFile("ACTION.USER.REGISTRATION.SUCCESS"), FacesMessage.SEVERITY_INFO);
			this.init();
		} catch (ValidationException exception) {
			MessagesUtils.addMessages(exception.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}
}
