package net.najiboulhouch.leavesmanagers.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import net.najiboulhouch.leavesmanagers.entities.Leave;
import net.najiboulhouch.leavesmanagers.services.LeaveService;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 */
@Named
@Scope("request")
public class LeaveConverter implements Converter {

	@Inject private LeaveService leaveService ;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		
		try {
			Leave leave = leaveService.findById(Long.valueOf(value));
			return leave;
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
		Leave leave  = (Leave) value;
		return String.valueOf(leave.getId());
	}

}
