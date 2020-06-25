package net.najiboulhouch.leavesmanagers.services;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import net.najiboulhouch.leavesmanagers.entities.LeaveApplication;
import net.najiboulhouch.leavesmanagers.entities.RecommendedLeave;
import net.najiboulhouch.leavesmanagers.entities.Status;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;
import net.najiboulhouch.leavesmanagers.repositories.RecommendedLeaveRepository;
import net.najiboulhouch.leavesmanagers.utils.Dates;
import net.najiboulhouch.leavesmanagers.utils.Filesi18n;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see RecommendedLeaveService, BaseServiceImpl
 */
@Named
@Transactional
public class RecommendedLeaveServiceImpl extends BaseServiceImpl<RecommendedLeave> implements RecommendedLeaveService {

	@Inject private RecommendedLeaveRepository recommendedLeaveRepository;
	@Inject	private LeaveApplicationService leaveApplicationService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RecommendedLeave> getPendingLeaves() throws ValidationException {
		return recommendedLeaveRepository.findByStatus(Status.PENDING);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveNewRecommendedLeave(RecommendedLeave recommendedLeave, LeaveApplication leaveApplication) throws ValidationException {
		/**
		 * Check if end Date is less than start date
		 */
		if (!Dates.isAfter(leaveApplication.getDateEndLeave(), leaveApplication.getDateStartLeave()))
			throw new ValidationException(Filesi18n.readMessageFromFile("ACTION.LEAVEAPPLICATION.CHECKDATE"));
		else {
			leaveApplication.setStatus(Status.ACCEPTED);
			leaveApplicationService.updateLeaveApplication(leaveApplication);

			/**
			 * Save new Recommended Leave
			 */
			recommendedLeave.setDateRecommended(new Date());
			recommendedLeave.setEmployee(leaveApplication.getPrimaryKey().getEmployee());
			recommendedLeave.setLeave(leaveApplication.getPrimaryKey().getLeave());
			recommendedLeave.setNumDays(
					Dates.getNbJoursBetween(leaveApplication.getDateStartLeave(), leaveApplication.getDateEndLeave()));
			recommendedLeave.setRecommendedBy(
					((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser()
							.getEmployee());
			save(recommendedLeave);
		}
	}
	
	

}
