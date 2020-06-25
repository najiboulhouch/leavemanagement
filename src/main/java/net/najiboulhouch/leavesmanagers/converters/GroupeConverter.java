package net.najiboulhouch.leavesmanagers.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import net.najiboulhouch.leavesmanagers.entities.Groupe;
import net.najiboulhouch.leavesmanagers.services.GroupeService;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 */
@Named
@Scope("request")
public class GroupeConverter implements Converter {

	@Inject private GroupeService groupeService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		
		try {
			return groupeService.findById(String.valueOf(value));
		} catch (NumberFormatException e) {
			throw new ConverterException(new FacesMessage(value + " is not a valid ID"), e);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return "";
		}
		if (value instanceof String && value.equals("")) {
			return "";
		}
		return String.valueOf(((Groupe) value).getName());
	}

}
