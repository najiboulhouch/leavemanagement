package net.najiboulhouch.leavesmanagers.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 20/12/2018
 * @see BaseEntity
 */

@Entity
@Table(name="TAB_ACCEPTED_LEAVES")
public class AcceptedLeave extends BaseEntity {

	@ManyToOne
	@JoinColumn(name="LEAVE_ID")
	private Leave leave;
	
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	private Employee employee;
	
	@Column(name="NUM_DAYS" , nullable=false)
	private int numDays;
	
	@Column(name="DATE_ACCEPTED")
	@Type(type="date")
	private Date dateAccepted;
	
	public AcceptedLeave() {
		super();
	}
	
	public Leave getLeave() {
		return leave;
	}
	public void setLeave(Leave leave) {
		this.leave = leave;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getNumDays() {
		return numDays;
	}
	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}
	public Date getDateAccepted() {
		return dateAccepted;
	}
	public void setDateAccepted(Date dateAccepted) {
		this.dateAccepted = dateAccepted;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof AcceptedLeave)
		{
			AcceptedLeave acceptedLeave = (AcceptedLeave) object;
			return  Objects.equals(getLeave() , acceptedLeave.getLeave()) && 
					Objects.equals(getNumDays(), acceptedLeave.getNumDays()) && 
					Objects.equals(getDateAccepted(), acceptedLeave.getDateAccepted());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getLeave()  , getNumDays() , getDateAccepted());
	}
	
}
