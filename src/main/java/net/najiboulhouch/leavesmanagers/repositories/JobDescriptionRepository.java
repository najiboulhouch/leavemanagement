/**
 * 
 */
package net.najiboulhouch.leavesmanagers.repositories;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.entities.JobDescription;

/**
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 * @see BaseRepository
 *
 */
public interface JobDescriptionRepository extends BaseRepository<JobDescription> {

	public JobDescription findByEmployee(Employee employee);
}
