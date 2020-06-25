package net.najiboulhouch.leavesmanagers.services;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.entities.JobDescription;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see BaseService
 *
 */
public interface JobDescriptionService extends BaseService<JobDescription> {
	
	/**
	 * 
	 * @param employee
	 * @return JobDescription
	 */
	public JobDescription findJobDescriptionByEmployee(Employee  employee) ;

}
