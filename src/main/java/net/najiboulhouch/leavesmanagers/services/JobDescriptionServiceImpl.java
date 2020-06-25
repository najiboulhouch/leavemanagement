package net.najiboulhouch.leavesmanagers.services;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.entities.JobDescription;
import net.najiboulhouch.leavesmanagers.repositories.JobDescriptionRepository;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see JobDescriptionService, BaseServiceImpl
 */
@Named
@Transactional
public class JobDescriptionServiceImpl extends BaseServiceImpl<JobDescription> implements JobDescriptionService  {

	@Inject private JobDescriptionRepository jobDescriptionRepository ;
	
	@Override
	public JobDescription findJobDescriptionByEmployee(Employee employee) {
		return jobDescriptionRepository.findByEmployee(employee);
	}

	
}
