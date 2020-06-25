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
@Table(name="TAB_REJECTED_LEAVES")
public class RejectedLeave extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name="LEAVE_ID")
	private Leave leave;
	
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	private Employee employee;
	
	@Column(name="REASON_REJECT")
	private String reasonReject;
	
	@Column(name="DATE_REJECTED")
	@Type(type="date")
	private Date dateRejected;
	
	public RejectedLeave() {
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
	public String getReasonReject() {
		return reasonReject;
	}
	public void setReasonReject(String reasonReject) {
		this.reasonReject = reasonReject;
	}
	public Date getDateRejected() {
		return dateRejected;
	}
	public void setDateRejected(Date dateRejected) {
		this.dateRejected = dateRejected;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RejectedLeave) {
			RejectedLeave rejectedLeave = (RejectedLeave) obj;
			return Objects.equals(getReasonReject(), rejectedLeave.getReasonReject()) &&
				   Objects.equals(getDateRejected(), rejectedLeave.getDateRejected()) &&
				   Objects.equals(getLeave(), rejectedLeave.getLeave()) &&
				   Objects.equals(getEmployee(), rejectedLeave.getEmployee()) ;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getReasonReject() , getDateRejected() , getLeave() , getEmployee());
	}
}
