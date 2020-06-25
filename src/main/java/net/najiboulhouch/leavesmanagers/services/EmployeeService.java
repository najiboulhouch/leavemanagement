package net.najiboulhouch.leavesmanagers.services;

import java.util.List;

import net.najiboulhouch.leavesmanagers.entities.Employee;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see BaseService
 *
 */
public interface EmployeeService extends BaseService<Employee> {

	/**
	 * 
	 * @return List of Employees
	 */
	public List<Employee> findEmployeesHaveNotSupervisor();
	
}
