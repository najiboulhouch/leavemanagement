package net.najiboulhouch.leavesmanagers.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 * @see BaseEntity
 */
@Entity
@Table(name="TAB_LEAVES")
public class Leave extends BaseEntity {

	@Column(name="LEAVE_TYPE")
	@Enumerated
	private LeaveType leaveType;
	
	@Column(name="ALLOWS_DAYS")
	private int allowsdays;
	
	@Column(name="CURRENT_DAYS")
	private int currentDays;
	
	@Column(name="ALLOWED_MONTHLY_DAYS")
	private int allowedMonthlyDays;
	
	@JoinColumn(name="FOR_STAFF_LEVEL")
	@ManyToOne
	private Groupe forStaffLevel;
	
	@OneToMany(mappedBy="leave")
	private List<AcceptedLeave> acceptedLeave;
	
	@OneToMany(mappedBy="leave")
	private List<RecommendedLeave> recommendedLeave;
	
	@OneToMany(mappedBy="leave")
	private List<RejectedLeave> rejectedLeave;
	
	public Leave() {
		super();
	}
	public Leave(LeaveType leaveType, int allowsdays, int currentDays, int allowedMonthlyDays, Groupe forStaffLevel) {
		super();
		this.leaveType = leaveType;
		this.allowsdays = allowsdays;
		this.currentDays = currentDays;
		this.allowedMonthlyDays = allowedMonthlyDays;
		this.forStaffLevel = forStaffLevel;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public int getAllowsdays() {
		return allowsdays;
	}
	public void setAllowsdays(int allowsdays) {
		this.allowsdays = allowsdays;
	}
	public int getCurrentDays() {
		return currentDays;
	}
	public void setCurrentDays(int currentDays) {
		this.currentDays = currentDays;
	}
	public int getAllowedMonthlyDays() {
		return allowedMonthlyDays;
	}
	public void setAllowedMonthlyDays(int allowedMonthlyDays) {
		this.allowedMonthlyDays = allowedMonthlyDays;
	}
	public Groupe getForStaffLevel() {
		return forStaffLevel;
	}
	public void setForStaffLevel(Groupe forStaffLevel) {
		this.forStaffLevel = forStaffLevel;
	}
	public List<AcceptedLeave> getAcceptedLeave() {
		return acceptedLeave;
	}
	public void setAcceptedLeave(List<AcceptedLeave> acceptedLeave) {
		this.acceptedLeave = acceptedLeave;
	}
	public List<RecommendedLeave> getRecommendedLeave() {
		return recommendedLeave;
	}
	public void setRecommendedLeave(List<RecommendedLeave> recommendedLeave) {
		this.recommendedLeave = recommendedLeave;
	}
	public List<RejectedLeave> getRejectedLeave() {
		return rejectedLeave;
	}
	public void setRejectedLeave(List<RejectedLeave> rejectedLeave) {
		this.rejectedLeave = rejectedLeave;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof Leave){
			Leave leave = (Leave) object;
			return   
					Objects.equals(getAllowsdays(), leave.getAllowsdays()) &&
					Objects.equals(getAllowedMonthlyDays(), leave.getAllowedMonthlyDays()) && 
					Objects.equals(getCurrentDays(), leave.getCurrentDays()) && 
					Objects.equals(getLeaveType(), leave.getLeaveType()) ;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getAllowedMonthlyDays() , getAllowsdays() , getCurrentDays() , 
				getLeaveType());
	}
}
