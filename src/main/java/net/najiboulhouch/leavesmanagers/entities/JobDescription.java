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
 * @since 1.0
 * @see BaseEntity
 */

@Entity
@Table(name="TAB_JOB_DESCRIPTION")
public class JobDescription extends BaseEntity {

	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID"  , unique=true)
	private Employee employee ;
	
	@Column(name="SALARY_LEVEL")
	private double salaryLevel;
	
	@Column(name="DATE_JOINED")
	@Type(type="date")
	private Date dateJoined;
	
	public JobDescription() {
		super();
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public double getSalaryLevel() {
		return salaryLevel;
	}
	public void setSalaryLevel(double salaryLevel) {
		this.salaryLevel = salaryLevel;
	}
	public Date getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof  JobDescription){
			JobDescription jobDescription = (JobDescription) obj ;
			return Objects.equals(getSalaryLevel(), jobDescription.getSalaryLevel()) &&	
					Objects.equals(getDateJoined(), jobDescription.getDateJoined()) ;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getSalaryLevel() , getDateJoined());
	}
	
}

