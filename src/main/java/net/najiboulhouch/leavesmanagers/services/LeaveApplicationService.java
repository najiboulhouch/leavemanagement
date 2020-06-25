package net.najiboulhouch.leavesmanagers.services;

import java.util.List;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.entities.LeaveApplication;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 */
public interface LeaveApplicationService {

	/**
	 * 
	 * @param employee
	 * @return list of LeavesApplication
	 */
	public List<LeaveApplication> findLeavesApplicationByEmployee(Employee employee);
	
	/**
	 * 
	 * @param leaveApplication
	 * @param detailsImpl
	 * @throws ValidationException
	 */
	public void saveNewLeaveApplication(LeaveApplication  leaveApplication , UserDetailsImpl detailsImpl) throws ValidationException;
	
	/**
	 * 
	 * @param employee
	 * @return list of LeaveApplication
	 */
	public List<LeaveApplication> findPendingLeavesForEmployee(Employee employee);
	
	/**
	 * 
	 * @param leaveApplication
	 * @throws ValidationException
	 */
	public void updateLeaveApplication(LeaveApplication leaveApplication) throws ValidationException;
	
	/**
	 * 
	 * @param employee
	 * @return list of LeaveApplication
	 */
	public List<LeaveApplication> findLeavesShouldBeRecommendedOrRejected( Employee employee);
}
