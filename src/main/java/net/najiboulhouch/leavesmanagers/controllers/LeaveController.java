package net.najiboulhouch.leavesmanagers.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import net.najiboulhouch.leavesmanagers.entities.Leave;
import net.najiboulhouch.leavesmanagers.entities.LeaveApplication;
import net.najiboulhouch.leavesmanagers.entities.LeaveType;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;
import net.najiboulhouch.leavesmanagers.services.LeaveApplicationService;
import net.najiboulhouch.leavesmanagers.services.LeaveService;
import net.najiboulhouch.leavesmanagers.utils.Filesi18n;
import net.najiboulhouch.leavesmanagers.utils.MessagesUtils;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 */

@Named
@Scope("view")
public class LeaveController extends BaseController<Leave> {

	@Inject private LeaveService leavesService;
	@Inject private LeaveApplicationService leaveApplicationService ;
	
	private List<LeaveApplication> pendingLeaves ;
	private LeaveType[] leavesType;
	
	@PostConstruct
	public void init() {
		super.init();
		entity = new Leave();
		leavesType = LeaveType.values();
		pendingLeaves = leaveApplicationService.findLeavesShouldBeRecommendedOrRejected(userDetails.getUser().getEmployee());	
	}

	public LeaveType[] getLeavesType() {
		return leavesType;
	}

	public void setLeavesType(LeaveType[] leavesType) {
		this.leavesType = leavesType;
	}

	public List<LeaveApplication> getPendingLeaves() {
		return pendingLeaves;
	}

	public void setPendingLeaves(List<LeaveApplication> pendingLeaves) {
		this.pendingLeaves = pendingLeaves;
	}

	/**
	 * 
	 * @throws ValidationException
	 */
	public void createNewLeave() throws ValidationException {
		try {
			leavesService.createNewLeaveType(entity);
			MessagesUtils.addMessages(Filesi18n.readMessageFromFile("ACTION.LEAVES.CREATE"), FacesMessage.SEVERITY_INFO);
			entity = new Leave();
		} catch (ValidationException exception) {
			MessagesUtils.addMessages(exception.getMessage(), FacesMessage.SEVERITY_ERROR);

		}
	}

}
