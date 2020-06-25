package net.najiboulhouch.leavesmanagers.controllers;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import org.springframework.security.core.context.SecurityContextHolder;

import net.najiboulhouch.leavesmanagers.entities.BaseEntity;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;
import net.najiboulhouch.leavesmanagers.services.BaseService;
import net.najiboulhouch.leavesmanagers.services.UserDetailsImpl;
import net.najiboulhouch.leavesmanagers.utils.Filesi18n;
import net.najiboulhouch.leavesmanagers.utils.MessagesUtils;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0	
 */
public abstract class BaseController<T extends BaseEntity> {

	@Inject protected BaseService<T> service ;
	protected T entity ;
	protected UserDetailsImpl userDetails;

	@PostConstruct
	public void init() {
		userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}
	
	public UserDetailsImpl getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsImpl userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * 
	 * @param msg
	 * @throws ValidationException
	 */
	public void save(String msg) throws ValidationException{
		try {
			service.save(entity);	
			MessagesUtils.addMessages(Filesi18n.readMessageFromFile(msg), FacesMessage.SEVERITY_INFO);
		} catch (Exception exception) {
			MessagesUtils.addMessages(exception.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}
	
	/**
	 * 
	 * @param msg
	 * @throws ValidationException
	 */
	public void delete(String msg) throws ValidationException{
		try {
			if(service.findOne(entity) != null){
				service.delete(entity);	
				MessagesUtils.addMessages(Filesi18n.readMessageFromFile(msg), FacesMessage.SEVERITY_INFO);
			}
			else {
				MessagesUtils.addMessages(Filesi18n.readMessageFromFile(msg), FacesMessage.SEVERITY_ERROR);
			}
			
		} catch (Exception exception) {
			MessagesUtils.addMessages(exception.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}
	
}
