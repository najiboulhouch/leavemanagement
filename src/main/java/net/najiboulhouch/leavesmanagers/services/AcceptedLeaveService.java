package net.najiboulhouch.leavesmanagers.services;

import java.util.List;

import net.najiboulhouch.leavesmanagers.entities.AcceptedLeave;
import net.najiboulhouch.leavesmanagers.entities.Employee;

/**
 * 
 * @author OULHOUCH
 * @version 1.0
 * @see BaseService
 */
public interface AcceptedLeaveService extends BaseService<AcceptedLeave> {

	/**
	 * 
	 * @param employee
	 * @return list of acceptedLeaves
	 */
	public List<AcceptedLeave> findAcceptedLeavesByEmployee(Employee employee);
}
