package net.najiboulhouch.leavesmanagers.converters;

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
public class EmployeeConverter implements Converter {

	@Inject private EmployeeService employeeService ;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		
		try {
			Employee employee = employeeService.findById(Long.valueOf(value));
			return employee;
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
		Employee employee = (Employee) value;
		return String.valueOf(employee.getId());
	}

}
