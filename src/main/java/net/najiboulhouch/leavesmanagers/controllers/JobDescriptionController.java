package net.najiboulhouch.leavesmanagers.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.entities.JobDescription;
import net.najiboulhouch.leavesmanagers.entities.Leave;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;
import net.najiboulhouch.leavesmanagers.services.EmployeeService;
import net.najiboulhouch.leavesmanagers.services.JobDescriptionService;
import net.najiboulhouch.leavesmanagers.services.LeaveService;
import net.najiboulhouch.leavesmanagers.utils.Filesi18n;
import net.najiboulhouch.leavesmanagers.utils.MessagesUtils;

/**
 * 
 * @author n.oulhouch
 *
 */
@Named
@Scope("view")
public class JobDescriptionController extends BaseController<JobDescription> {

	@Inject private EmployeeService employeeService;
	@Inject private JobDescriptionService jobDescriptionService;
	@Inject private LeaveService leaveService;
	
	private List<Employee> employees;
	private JobDescription jobDescriptionsForConncetdUser; 
	private List<Leave> leavesForStatistics ;
	
	@PostConstruct
	public void init() {
		super.init();
		employees = employeeService.findAll();
		jobDescriptionsForConncetdUser = (JobDescription) jobDescriptionService.findJobDescriptionByEmployee(userDetails.getUser().getEmployee());
		leavesForStatistics = leaveService.findLeavesForOneGroupe(userDetails.getUser().getGroupe());
		entity = new JobDescription();
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public JobDescription getJobDescriptionsForConncetdUser() {
		return jobDescriptionsForConncetdUser;
	}

	public void setJobDescriptionsForConncetdUser(JobDescription jobDescriptionsForConncetdUser) {
		this.jobDescriptionsForConncetdUser = jobDescriptionsForConncetdUser;
	}

	public List<Leave> getLeavesForStatistics() {
		return leavesForStatistics;
	}

	public void setLeavesForStatistics(List<Leave> leavesForStatistics) {
		this.leavesForStatistics = leavesForStatistics;
	}

	/**
	 * 
	 * @throws ValidationException
	 */
	public void save() throws ValidationException {
		if (service.findById(entity.getEmployee().getId()) != null)
			MessagesUtils.addMessages(Filesi18n.readMessageFromFile("ACTION.JOBDESCRIPTION.EMPLOYEE.EXISTS"),
					FacesMessage.SEVERITY_ERROR);
		else {
			super.save("ACTION.JOBDESCRIPTION.CREATE");
			entity = new JobDescription();
		}
	}

}
