package net.najiboulhouch.leavesmanagers.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import net.najiboulhouch.leavesmanagers.entities.AcceptedLeave;
import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.repositories.AcceptedLeaveRepository;

/**
 * 
 * @author OULHOUCH
 * @version 1.0
 * @see AcceptedLeave , BaseServiceImpl
 */
@Named
@Transactional
public class AcceptedLeaveServiceImpl extends BaseServiceImpl<AcceptedLeave> implements AcceptedLeaveService {

	@Inject private AcceptedLeaveRepository acceptedLeaveRepository ;
	
	@Override
	public List<AcceptedLeave> findAcceptedLeavesByEmployee(Employee employee) {
		return acceptedLeaveRepository.findByEmployee(employee);
	}

}
