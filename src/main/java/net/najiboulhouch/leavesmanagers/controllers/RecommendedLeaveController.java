package net.najiboulhouch.leavesmanagers.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

import net.najiboulhouch.leavesmanagers.entities.LeaveApplication;
import net.najiboulhouch.leavesmanagers.entities.RecommendedLeave;
import net.najiboulhouch.leavesmanagers.entities.Status;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;
import net.najiboulhouch.leavesmanagers.services.RecommendedLeaveService;
import net.najiboulhouch.leavesmanagers.utils.MessagesUtils;

/**
 * <h3>Class : LeavesController</h3>
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 * @see BaseController
 */

@Named
@Scope("view")
public class RecommendedLeaveController extends BaseController<RecommendedLeave> {

	@Inject	private RecommendedLeaveService recommendedLeaveService;
	private List<RecommendedLeave> recommendedLeaves;

	@Override
	@PostConstruct
	public void init() {
		try {
			recommendedLeaves = recommendedLeaveService.getPendingLeaves();
			entity = new RecommendedLeave();
		} catch (ValidationException exception) {
			MessagesUtils.addMessages(exception.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}

	public List<RecommendedLeave> getRecommendedLeaves() {
		return recommendedLeaves;
	}

	public void setRecommendedLeaves(List<RecommendedLeave> recommendedLeaves) {
		this.recommendedLeaves = recommendedLeaves;
	}

	/**
	 * Change status for selected leave
	 * 
	 * @param status
	 * @param recommendedLeave
	 */
	public void changeStatusRecommendedLeave(boolean status, RecommendedLeave recommendedLeave) {
		try {
			if (status)
				recommendedLeave.setStatus(Status.ACCEPTED);
			else
				recommendedLeave.setStatus(Status.REJECTED);
			super.save("ACTION.RECOMMENDED.LEAVES.UPDATE");
			this.init();
		} catch (ValidationException exception) {
			MessagesUtils.addMessages(exception.getMessage(), FacesMessage.SEVERITY_ERROR);
		}

	}
	
	/**
	 * 
	 * @param leaveApplication
	 * @throws ValidationException
	 */
	public void save(LeaveApplication leaveApplication) {
		RequestContext context = RequestContext.getCurrentInstance();
		try {
			recommendedLeaveService.saveNewRecommendedLeave(entity , leaveApplication);
			context.execute("PF(\'dlg1\').show()");
		} catch (ValidationException exception) {			
			MessagesUtils.addMessages(exception.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}
	
	/**
	 * @throws ValidationException
	 */
	public void update(){
		try {
			super.save("ACTION.RECOMMENDEDLEAVE.CREATE");
			this.init();
		} catch (ValidationException exception) {	
			MessagesUtils.addMessages(exception.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}

}
