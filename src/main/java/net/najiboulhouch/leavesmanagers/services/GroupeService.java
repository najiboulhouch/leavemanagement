package net.najiboulhouch.leavesmanagers.services;

import java.util.List;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.entities.Groupe;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 */
public interface GroupeService {

	/**
	 * 
	 * @return list of Groupe
	 */
	public List<Groupe> getAllGroups();
	
	/**
	 * 
	 * @param id
	 * @return Groupe
	 */
	public Groupe findById(String id);
	
	/**
	 * 
	 * @return list of Employees
	 */
	public List<Employee> findEmployeesWithSupervisorRole();
	
}
