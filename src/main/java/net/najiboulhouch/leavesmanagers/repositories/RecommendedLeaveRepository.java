package net.najiboulhouch.leavesmanagers.repositories;

import java.util.List;

import net.najiboulhouch.leavesmanagers.entities.RecommendedLeave;
import net.najiboulhouch.leavesmanagers.entities.Status;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 * @see BaseRepository
 */
public interface RecommendedLeaveRepository extends BaseRepository<RecommendedLeave> {

	
	public List<RecommendedLeave> findByStatus(Status status);
	
}
