package net.najiboulhouch.leavesmanagers.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 20/12/2018
 */

@Embeddable
public class LeaveApplicationId  implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade=CascadeType.ALL)
	private Leave leave;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Employee employee;
	
	public LeaveApplicationId() {
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
	
	
}
