package net.najiboulhouch.leavesmanagers.repositories;

import java.util.List;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.entities.RejectedLeave;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 * @see BaseRepository
 *
 */
public interface RejectedLeaveRepository extends BaseRepository<RejectedLeave> { 

	 public List<RejectedLeave> findByEmployee(Employee employee);
	
}
