package net.najiboulhouch.leavesmanagers.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;
import net.najiboulhouch.leavesmanagers.services.EmployeeService;
import net.najiboulhouch.leavesmanagers.services.GroupeService;
import net.najiboulhouch.leavesmanagers.utils.Filesi18n;
import net.najiboulhouch.leavesmanagers.utils.MessagesUtils;

/**
 * 
 * @author OULHOUCH
 * @version 1.0
 */
@Named
@Scope("view")
public class EmployeeController extends BaseController<Employee> {

	@Inject	private EmployeeService employeeService;
	@Inject	private GroupeService groupeService;
	
	private List<Employee> employeesWithNotSupervisor;
	private List<Employee> employeesWithSupervisorRole;
	private Employee assignedSupervisor;
	private Employee supervisor;

	@PostConstruct
	public void init() {
		employeesWithNotSupervisor = employeeService.findEmployeesHaveNotSupervisor();
		employeesWithSupervisorRole = groupeService.findEmployeesWithSupervisorRole();
		assignedSupervisor = null;
		supervisor = null;
	}

	public List<Employee> getEmployeesWithNotSupervisor() {
		return employeesWithNotSupervisor;
	}

	public void setEmployeesWithNotSupervisor(List<Employee> employeeWithNotSupervisor) {
		this.employeesWithNotSupervisor = employeeWithNotSupervisor;
	}

	public List<Employee> getEmployeesWithSupervisorRole() {
		return employeesWithSupervisorRole;
	}

	public void setEmployeesWithSupervisorRole(List<Employee> employeesSupervisor) {
		this.employeesWithSupervisorRole = employeesSupervisor;
	}

	public Employee getAssignedSupervisor() {
		return assignedSupervisor;
	}

	public void setAssignedSupervisor(Employee selectedAssignedSupervisor) {
		this.assignedSupervisor = selectedAssignedSupervisor;
	}

	public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

	/**
	 * 
	 * @throws ValidationException
	 */
	public void save() throws ValidationException {
		if (supervisor.equals(assignedSupervisor))
			MessagesUtils.addMessages(Filesi18n.readMessageFromFile("ACTION.EMPLOYEES.ASSIGNSUPERVISOR.EXIST"), FacesMessage.SEVERITY_ERROR);
		else {
			try {
				assignedSupervisor.setSupervisor(supervisor);
				service.save(assignedSupervisor);
				this.init();
				MessagesUtils.addMessages(Filesi18n.readMessageFromFile("ACTION.EMPLOYEES.ASSIGNSUPERVISOR.CREATE"),FacesMessage.SEVERITY_INFO);
			} catch (ValidationException exception) {
				MessagesUtils.addMessages(exception.getMessage(), FacesMessage.SEVERITY_ERROR);
			}
		}
	}

}
