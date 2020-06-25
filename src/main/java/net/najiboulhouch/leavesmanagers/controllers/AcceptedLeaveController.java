package net.najiboulhouch.leavesmanagers.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import net.najiboulhouch.leavesmanagers.entities.AcceptedLeave;
import net.najiboulhouch.leavesmanagers.services.AcceptedLeaveService;

@Named
@Scope("view")
public class AcceptedLeaveController extends BaseController<AcceptedLeave> {

	@Inject private AcceptedLeaveService acceptedLeaveService ;
	private List<AcceptedLeave> acceptedLeaves ;
	
	
	@Override
	@PostConstruct
	public void init() {
		super.init();
		acceptedLeaves = acceptedLeaveService.findAcceptedLeavesByEmployee(userDetails.getUser().getEmployee());
	}


	public List<AcceptedLeave> getAcceptedLeaves() {
		return acceptedLeaves;
	}


	public void setAcceptedLeaves(List<AcceptedLeave> acceptedLeaves) {
		this.acceptedLeaves = acceptedLeaves;
	}
	
	
	
	
}
