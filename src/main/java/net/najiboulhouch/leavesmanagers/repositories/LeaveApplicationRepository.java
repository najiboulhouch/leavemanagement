/**
 * 
 */
package net.najiboulhouch.leavesmanagers.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.entities.LeaveApplication;
import net.najiboulhouch.leavesmanagers.entities.LeaveApplicationId;
import net.najiboulhouch.leavesmanagers.entities.Status;

/**
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 * @see CrudRepository
 *
 */
public interface LeaveApplicationRepository extends CrudRepository<LeaveApplication, LeaveApplicationId> {

	public List<LeaveApplication> findByPrimaryKeyEmployee(Employee employee);
	
	public List<LeaveApplication> findByPrimaryKeyEmployeeAndStatus(Employee employee , Status status);
	
	public List<LeaveApplication> findByPrimaryKeyEmployeeSupervisorAndStatus(Employee supervisor , Status status);
	
	
}
