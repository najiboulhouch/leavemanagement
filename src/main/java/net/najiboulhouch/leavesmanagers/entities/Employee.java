package net.najiboulhouch.leavesmanagers.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name="TAB_EMPLOYES")
public class Employee extends BaseEntity {
	
	@Column(name="TITLE")
	private String title ;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@ManyToOne
	@JoinColumn(name="SUPERVISOR_ID")
	private Employee supervisor;
	
	@Column(name="DATE_REGISTRED")
	@Type(type="date")
	private Date dateRegistred;
	
	@OneToMany(mappedBy="employee")
	private List<AcceptedLeave> acceptedLeave = new ArrayList<AcceptedLeave>() ; 
	
	@OneToMany(mappedBy="recommendedBy")
	private List<RecommendedLeave> recommendedLeave = new ArrayList<RecommendedLeave>();
	
	@OneToMany(mappedBy="employee")
	private List<RejectedLeave> rejectedLeave = new ArrayList<RejectedLeave>();
	
	@OneToOne(mappedBy="employee")
	private User user ;
	
	public Employee() {
		super();
	}
	public Employee(String title, String firstName, String lastName, String email, Date dateRegistred) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateRegistred = dateRegistred;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}
	public Date getDateRegistred() {
		return dateRegistred;
	}
	public void setDateRegistred(Date dateRegistred) {
		this.dateRegistred = dateRegistred;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee){
			Employee employee = (Employee) obj;
			return Objects.equals(getFirstName(), employee.getFirstName()) && 
				   Objects.equals(getLastName(), employee.getLastName()) &&
				   Objects.equals(getTitle(), employee.getTitle()) &&
				   Objects.equals(getDateRegistred(), employee.getDateRegistred()) &&
				   Objects.equals(getEmail(), employee.getEmail());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getFirstName() , getLastName() , getTitle() , getDateRegistred() , getEmail()) ;
	}

}
