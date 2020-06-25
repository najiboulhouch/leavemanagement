package net.najiboulhouch.leavesmanagers.services;

import java.util.List;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.entities.RejectedLeave;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see BaseService
 */
public interface RejectedLeaveService extends BaseService<RejectedLeave> {

	/**
	 * 
	 * @param employee
	 * @return list of RejectedLeaves
	 */
	public List<RejectedLeave> findRejectedLeavesByEmployee(Employee employee);
}
