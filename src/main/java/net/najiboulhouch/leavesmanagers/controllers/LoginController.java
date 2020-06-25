package net.najiboulhouch.leavesmanagers.controllers;

import java.io.IOException;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;

import net.najiboulhouch.leavesmanagers.utils.MessagesUtils;

/**
 * This controller allow users to connect to our system.
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 * @see PhaseListener
 */

@Named
@Scope("session")
public class LoginController implements PhaseListener {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Locale localeLanguage;

	public Locale getLocaleLanguage() {
		return localeLanguage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@PostConstruct
	public void init() {
		localeLanguage = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	}
  
	/**
	 * 
	 * @return String
	 * @throws ServletException
	 * @throws IOException
	 */
	public String login() throws ServletException, IOException {
		ExternalContext context 	 = FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward((ServletRequest) context.getRequest(),(ServletResponse) context.getResponse());
		FacesContext.getCurrentInstance().responseComplete();
		return null;
	}
	
	/**
	 * @param PhaseEvent
	 */
    public void beforePhase(PhaseEvent event) throws AuthenticationException {
    	AuthenticationException exception = (AuthenticationException) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);
        if (exception != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
            MessagesUtils.addMessages(exception.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
	@Override
	public void afterPhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
