package net.najiboulhouch.leavesmanagers.repositories;

import java.util.List;

import net.najiboulhouch.leavesmanagers.entities.AcceptedLeave;
import net.najiboulhouch.leavesmanagers.entities.Employee;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 * 
 */
public interface AcceptedLeaveRepository extends BaseRepository<AcceptedLeave> {

	
	public List<AcceptedLeave> findByEmployee(Employee employee);
}