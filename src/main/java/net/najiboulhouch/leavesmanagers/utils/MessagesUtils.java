package net.najiboulhouch.leavesmanagers.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 */
public abstract class MessagesUtils {
	
	/**
	 * 
	 * @param msgs
	 * @param severity
	 */
	public static void addMessages(String msgs , Severity severity){
		FacesMessage facesMessage  = new FacesMessage(severity,	msgs , null);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage("msgs" , facesMessage);
	}

}
