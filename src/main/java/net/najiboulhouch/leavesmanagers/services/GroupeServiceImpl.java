package net.najiboulhouch.leavesmanagers.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import net.najiboulhouch.leavesmanagers.entities.Employee;
import net.najiboulhouch.leavesmanagers.entities.Groupe;
import net.najiboulhouch.leavesmanagers.entities.User;
import net.najiboulhouch.leavesmanagers.repositories.GroupeRepository;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see GroupeService
 */

@Named
@Transactional
public class GroupeServiceImpl implements GroupeService {

	@Inject private GroupeRepository groupeRepository ;
	
	public List<Groupe> getAllGroups(){
		return (List<Groupe>) groupeRepository.findAll();
	}

	@Override
	public Groupe findById(String id) {
		return groupeRepository.findOne(id);
	}

	@Override
	public List<Employee> findEmployeesWithSupervisorRole() {
		Groupe groupe = groupeRepository.findOne("SUPERVISOR");
		List<Employee> employees = new ArrayList<>() ;
		for (User user : groupe.getUsers()) {
			employees.add(user.getEmployee());
		}
		return employees;
	}
}
