package net.najiboulhouch.leavesmanagers.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import net.najiboulhouch.leavesmanagers.entities.Groupe;
import net.najiboulhouch.leavesmanagers.services.GroupeService;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 */
@Named
public class GroupeController {

	@Inject private GroupeService groupeService ;
	private List<Groupe> groupes;
	
	@PostConstruct
	public void init(){
		groupes = groupeService.getAllGroups();
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	
}
