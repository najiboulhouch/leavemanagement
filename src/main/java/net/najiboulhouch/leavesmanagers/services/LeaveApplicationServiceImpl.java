package net.najiboulhouch.leavesmanagers.services;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.entities.LeaveApplication;
import net.najiboulhouch.leavesmanagers.entities.Status;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;
import net.najiboulhouch.leavesmanagers.repositories.LeaveApplicationRepository;
import net.najiboulhouch.leavesmanagers.utils.Dates;
import net.najiboulhouch.leavesmanagers.utils.Filesi18n;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see LeaveApplicationService
 */

@Named
@Transactional(rollbackFor={ValidationException.class})
public class LeaveApplicationServiceImpl implements LeaveApplicationService {

	@Inject private LeaveApplicationRepository leaveApplicationRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LeaveApplication> findLeavesApplicationByEmployee(Employee employee) {
		return leaveApplicationRepository.findByPrimaryKeyEmployee(employee);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveNewLeaveApplication(LeaveApplication leaveApplication, UserDetailsImpl detailsImpl) throws ValidationException {
		if (!Dates.isAfter(leaveApplication.getDateEndLeave(), leaveApplication.getDateStartLeave())) {
			throw new ValidationException(Filesi18n.readMessageFromFile("ACTION.LEAVEAPPLICATION.CHECKDATE"));
		} else {
			leaveApplication.getPrimaryKey().setEmployee(detailsImpl.getUser().getEmployee());
			if(leaveApplicationRepository.findOne(leaveApplication.getPrimaryKey()) != null)
			{
				throw new ValidationException(Filesi18n.readMessageFromFile("ACTION.LEAVEAPPLICATION.CREATE.EXISTS"));
			}
			else {
				leaveApplication.setStatus(Status.PENDING);
				leaveApplication.setDateRequested(new Date()) ;
				leaveApplicationRepository.save(leaveApplication);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LeaveApplication> findPendingLeavesForEmployee(Employee employee) {
		return leaveApplicationRepository.findByPrimaryKeyEmployeeAndStatus(employee , Status.PENDING);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateLeaveApplication(LeaveApplication leaveApplication) throws ValidationException {
		leaveApplicationRepository.save(leaveApplication);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LeaveApplication> findLeavesShouldBeRecommendedOrRejected(Employee employee) {
		return leaveApplicationRepository.findByPrimaryKeyEmployeeSupervisorAndStatus(employee, Status.PENDING);
	}
	

}
