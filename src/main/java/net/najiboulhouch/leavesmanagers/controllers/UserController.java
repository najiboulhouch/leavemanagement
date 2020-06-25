package net.najiboulhouch.leavesmanagers.controllers;

import java.io.IOException;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;

import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;
import net.najiboulhouch.leavesmanagers.services.UserDetailsImpl;
import net.najiboulhouch.leavesmanagers.services.UserService;
import net.najiboulhouch.leavesmanagers.utils.Filesi18n;
import net.najiboulhouch.leavesmanagers.utils.MessagesUtils;

/**
 * <h3>Class : UserController</h3>
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 * @see BaseController
 */
@Named
@Scope("session")
public class UserController {

	@Inject
	private UserService userService;
	private UserDetailsImpl userDetailsImpl;
	private boolean enableDeleteAccountButton;
	private String currentPassword;
	private boolean enableOrDisablePassword;
	private Locale locale;

	public Locale getLocale() {
		return locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void setLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public boolean isEnableOrDisablePassword() {
		return enableOrDisablePassword;
	}

	public void setEnableOrDisablePassword(boolean enableOrDisablePassword) {
		this.enableOrDisablePassword = enableOrDisablePassword;
	}

	public boolean isEnableDeleteAccountButton() {
		return enableDeleteAccountButton;
	}

	public void setEnableDeleteAccountButton(boolean enableDeleteAccountButton) {
		this.enableDeleteAccountButton = enableDeleteAccountButton;
	}

	public void setUserDetailsImpl(UserDetailsImpl userDetailsImpl) {
		this.userDetailsImpl = userDetailsImpl;
	}

	public UserDetailsImpl getUserDetailsImpl() {
		return userDetailsImpl;
	}

	@PostConstruct
	public void init() {
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		userDetailsImpl = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		enableDeleteAccountButton = false;
		enableOrDisablePassword = true;
	}

	/**
	 * Disable/Enable delete button Method
	 */
	public void checkDeleteButton() {
		if (enableDeleteAccountButton)
			enableDeleteAccountButton = false;
		else
			enableDeleteAccountButton = true;
	}

	/**
	 * Update User Account Method
	 * 
	 * @throws ValidationException
	 */
	public void updateUser() throws ValidationException {
		try {
			userService.saveUser(userDetailsImpl.getUser(), currentPassword);
			MessagesUtils.addMessages(Filesi18n.readMessageFromFile("ACTION.USER.ACCOUNT.UPDATE"),
					FacesMessage.SEVERITY_INFO);
		} catch (ValidationException e) {
			MessagesUtils.addMessages(e.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}

	/**
	 * Change Password Method
	 * 
	 * @throws ValidationException
	 */
	public void changePassword() throws ValidationException {
		if (enableOrDisablePassword) {
			enableOrDisablePassword = false;
		} else {
			try {
				userService.changePassword(userDetailsImpl.getUser(), currentPassword);
				enableOrDisablePassword = true;
				MessagesUtils.addMessages(Filesi18n.readMessageFromFile("ACTION.USER.PASSWORD.UPDATE"),
						FacesMessage.SEVERITY_INFO);
			} catch (ValidationException e) {
				MessagesUtils.addMessages(e.getMessage(), FacesMessage.SEVERITY_ERROR);
			}
		}
	}

	/**
	 * Delete Account Method
	 * 
	 * @throws IOException
	 * @throws ValidationException
	 */
	public void deleteAccount() throws IOException, ValidationException {
		try {
			userService.deleteAccount(userDetailsImpl.getUser(), currentPassword);
			MessagesUtils.addMessages(Filesi18n.readMessageFromFile("ACTION.USER.ACCOUNT.DELETE"),
					FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().getExternalContext().redirect(
					FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath() + "/logout");
		} catch (ValidationException e) {
			MessagesUtils.addMessages(e.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}

}
