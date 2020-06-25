package net.najiboulhouch.leavesmanagers.repositories;

import java.util.List;

import net.najiboulhouch.leavesmanagers.entities.Groupe;
import net.najiboulhouch.leavesmanagers.entities.Leave;
import net.najiboulhouch.leavesmanagers.entities.LeaveType;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 * @see BaseRepository
 *
 */
public interface LeaveRepository extends BaseRepository<Leave> {

	public Leave findByLeaveTypeAndForStaffLevel(LeaveType leaveType , Groupe groupe);
	public List<Leave> findByForStaffLevel(Groupe groupe);
}
