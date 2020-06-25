package net.najiboulhouch.leavesmanagers.services;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import net.najiboulhouch.leavesmanagers.entities.Groupe;
import net.najiboulhouch.leavesmanagers.entities.Leave;
import net.najiboulhouch.leavesmanagers.exceptions.ValidationException;
import net.najiboulhouch.leavesmanagers.repositories.LeaveRepository;
import net.najiboulhouch.leavesmanagers.utils.Filesi18n;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @see LeaveService, BaseServiceImpl
 */
@Named
@Transactional
public class LeaveServiceImpl extends BaseServiceImpl<Leave> implements LeaveService {

	@Inject private LeaveRepository leaveRepository ;
	
	@Override
	public void createNewLeaveType(Leave leave) throws ValidationException {
		if(isTypeExists(leave))
			throw new ValidationException(Filesi18n.readMessageFromFile("ACTION.LEAVES.TYPE.EXISTS"));
		else{
			leave.setCurrentDays(leave.getAllowsdays());
			super.save(leave);
		}
	}

	/**
	 * 
	 * @param leave
	 * @return boolean
	 */
	private boolean isTypeExists(Leave  leave) {
		Leave leaveResult = leaveRepository.findByLeaveTypeAndForStaffLevel(leave.getLeaveType() , leave.getForStaffLevel());
		return leaveResult != null ? true : false;
	}

	@Override
	public List<Leave> findLeavesForOneGroupe(Groupe groupe) {
		return leaveRepository.findByForStaffLevel(groupe);
	}
}
