package net.najiboulhouch.leavesmanagers.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.repositories.EmployeeRepository;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see EmployeeService, BaseService
 *
 */
@Named
@Transactional
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService {

	@Inject private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findEmployeesHaveNotSupervisor() {
		return employeeRepository.findBySupervisorIsNull();
	}

}
