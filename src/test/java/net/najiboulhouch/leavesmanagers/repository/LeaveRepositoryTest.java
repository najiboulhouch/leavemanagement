package net.najiboulhouch.leavesmanagers.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import net.najiboulhouch.leavesmanagers.entities.Groupe;
import net.najiboulhouch.leavesmanagers.entities.Leave;
import net.najiboulhouch.leavesmanagers.entities.LeaveType;
import net.najiboulhouch.leavesmanagers.repositories.GroupeRepository;
import net.najiboulhouch.leavesmanagers.repositories.LeaveRepository;

@ContextConfiguration(locations="classpath:**/applicationContext.xml")
@ActiveProfiles("test")
@Transactional
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
public class LeaveRepositoryTest {

	
	@Autowired private LeaveRepository  leaveRepository ;
	@Autowired private GroupeRepository groupeRepository ;
	
	@Test	
	public void testFindByLeaveTypeAndForStaffLevel() throws Exception{
		Groupe groupe = groupeRepository.findOne("Administrator");
		Leave leave = new Leave(LeaveType.STUDY_LEAVE , 30 , 30 , 10 , groupe ) ; 
		leaveRepository.save(leave);
		
		assertThat(leaveRepository.findByLeaveTypeAndForStaffLevel(LeaveType.STUDY_LEAVE, groupeRepository.findOne("Administrator")).getId() , is(leave.getId()));
							
	}
}
