package net.najiboulhouch.leavesmanagers.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.entities.RejectedLeave;
import net.najiboulhouch.leavesmanagers.repositories.RejectedLeaveRepository;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see RejectedLeaveService, BaseServiceImpl
 */
@Named
@Transactional
public class RejectedLeaveServiceImpl extends BaseServiceImpl<RejectedLeave> implements RejectedLeaveService {

	@Inject private RejectedLeaveRepository rejectedLeaveRepository ;
	
	@Override
	public List<RejectedLeave> findRejectedLeavesByEmployee(Employee employee) {
		return rejectedLeaveRepository.findByEmployee(employee);
	}
}
