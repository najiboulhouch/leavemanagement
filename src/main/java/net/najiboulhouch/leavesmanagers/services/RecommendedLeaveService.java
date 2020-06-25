package net.najiboulhouch.leavesmanagers.services;

import java.util.List;

import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;
import net.najiboulhouch.leavesmanagers.entities.LeaveApplication;
import net.najiboulhouch.leavesmanagers.entities.RecommendedLeave;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see BaseService
 */
public interface RecommendedLeaveService extends BaseService<RecommendedLeave> {

	/**
	 * 
	 * @return list of RecommendedLeaves
	 * @throws ValidationException
	 */
	public List<RecommendedLeave> getPendingLeaves() throws ValidationException;
	
	/**
	 * 
	 * @param recommendedLeave
	 * @throws ValidationException
	 */
	public void saveNewRecommendedLeave(RecommendedLeave recommendedLeave , LeaveApplication leaveApplication) throws ValidationException;
	
}
