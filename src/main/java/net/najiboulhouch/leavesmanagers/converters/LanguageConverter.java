package net.najiboulhouch.leavesmanagers.converters;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.services.EmployeeService;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 */
@Named
@Scope("request")
public class LanguageConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		
			Map<String, String> countries;
			countries = new LinkedHashMap<String, String>();
			countries.put("English", Locale.ENGLISH.getLanguage());
			countries.put("French", Locale.FRENCH.getLanguage());
		
		try {
			for (Map.Entry<String, String> entry : countries.entrySet()) {
				if (entry.getValue().toString().equals(value)) {
					return new Locale(entry.getValue());
				}
			}
			return null;
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
		return String.valueOf(value);
	}

}
