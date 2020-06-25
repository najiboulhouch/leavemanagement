package net.najiboulhouch.leavesmanagers.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;

import net.najiboulhouch.leavesmanagers.entities.Leave;
import net.najiboulhouch.leavesmanagers.entities.LeaveApplication;
import net.najiboulhouch.leavesmanagers.entities.Status;
import net.najiboulhouch.leavesmanagers.services.LeaveApplicationService;
import net.najiboulhouch.leavesmanagers.services.LeaveService;
import net.najiboulhouch.leavesmanagers.services.UserDetailsImpl;
import net.najiboulhouch.leavesmanagers.utils.Filesi18n;
import net.najiboulhouch.leavesmanagers.utils.MessagesUtils;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 */

@Named
@Scope("view")
public class LeaveApplicationController {

	@Inject private LeaveApplicationService leaveApplicationService ;
	@Inject private LeaveService leaveService;
	
	private List<LeaveApplication> leaveApplications ;
	private List<Leave> leaves ;
	private LeaveApplication leaveApplication ;
	private UserDetailsImpl  connectedUser ;
	
	
	@PostConstruct
	private void init() {
		connectedUser = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		leaveApplications = leaveApplicationService.findLeavesApplicationByEmployee(connectedUser.getUser().getEmployee());
		leaves = leaveService.findLeavesForOneGroupe(connectedUser.getUser().getGroupe());
		leaveApplication = new LeaveApplication();	
	}
	
	
	
	public List<Leave> getLeaves() {
		return leaves;
	}
	public void setLeaves(List<Leave> leaves) {
		this.leaves = leaves;
	}
	public List<LeaveApplication> getLeaveApplications() {
		return leaveApplications;
	}
	public void setLeaveApplications(List<LeaveApplication> leaveApplications) {
		this.leaveApplications = leaveApplications;
	}
	public LeaveApplication getLeaveApplication() {
		return leaveApplication;
	}
	public void setLeaveApplication(LeaveApplication leaveApplication) {
		this.leaveApplication = leaveApplication;
	}

	public void save(){
		try {
			leaveApplicationService.saveNewLeaveApplication(leaveApplication, connectedUser);
			MessagesUtils.addMessages(Filesi18n.readMessageFromFile("ACTION.LEAVEAPPLICATION.CREATE"), FacesMessage.SEVERITY_INFO);
			this.init();
		} catch (ValidationException exception) {
			MessagesUtils.addMessages(exception.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}
	
	


}
