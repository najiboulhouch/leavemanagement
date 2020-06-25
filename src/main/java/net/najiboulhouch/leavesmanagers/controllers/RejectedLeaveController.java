package net.najiboulhouch.leavesmanagers.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import net.najiboulhouch.leavesmanagers.entities.RejectedLeave;
import net.najiboulhouch.leavesmanagers.services.RejectedLeaveService;

/**
 * 
 * @author OULHOUCH
 * @version 1.0
 */
@Named
@Scope("view")
public class RejectedLeaveController extends BaseController<RejectedLeave> {
	@Inject private RejectedLeaveService rejectedLeaveService ;
	private List<RejectedLeave> rejectedLeaves ;
	
	@PostConstruct
	public void init() {
		super.init();
		rejectedLeaves = rejectedLeaveService.findRejectedLeavesByEmployee(userDetails.getUser().getEmployee());
	}
	
	public List<RejectedLeave> getRejectedLeaves() {
		return rejectedLeaves;
	}

	public void setRejectedLeaves(List<RejectedLeave> rejectedLeaves) {
		this.rejectedLeaves = rejectedLeaves;
	}
	
}
