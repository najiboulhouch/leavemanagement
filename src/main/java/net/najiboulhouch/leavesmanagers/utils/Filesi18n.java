package net.najiboulhouch.leavesmanagers.utils;

import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.MessageSource;

import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 */
@Named
public class Filesi18n  {

	private static MessageSource messageSource;

	@Inject
	public void setMessageSource(MessageSource messageSource) {
		Filesi18n.messageSource = messageSource;
	}

	/**
	 * 
	 * @param code
	 * @return String
	 * @throws ValidationException
	 */
	public static String readMessageFromFile(String code) throws ValidationException {
	Locale currentLocale =  FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		return messageSource.getMessage(code, null, currentLocale);
	}
}
