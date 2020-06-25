package net.najiboulhouch.leavesmanagers.services;

import java.util.List;

import net.najiboulhouch.leavesmanagers.entities.Groupe;
import net.najiboulhouch.leavesmanagers.entities.Leave;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see BaseService
 *
 */
public interface LeaveService extends BaseService<Leave> {

	/**
	 * 
	 * @param leave
	 * @throws ValidationException
	 */
	public void createNewLeaveType(Leave leave) throws ValidationException;
	
	/**
	 * 
	 * @param groupe
	 * @return list of leaves
	 */
	public List<Leave> findLeavesForOneGroupe(Groupe groupe);
	
}
