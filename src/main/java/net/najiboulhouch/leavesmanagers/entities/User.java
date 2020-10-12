package net.najiboulhouch.leavesmanagers.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 20/12/2018
 */

@Entity
@Table(name="TAB_USERS")
public class User {

	@Column(name="PHONE")
	private String phone;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="DATE_REGISTRED")
	@Type(type="date")
	private Date dateRegistred;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="ENABLED")
	private boolean enabled;
	
	@Column(name="USER_NAME")
	@Id
	private String userName;
	
	@Column(name="EMAIL")
	private String email;
	
	@OneToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="GROUPE_ID")
	private Groupe groupe;
	
	@Column(name="LANGAGE")
	private String lng;
	
	
	public User() {
		super();
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public Date getDateRegistred() {
		return dateRegistred;
	}
	public void setDateRegistred(Date dateRegistred) {
		this.dateRegistred = dateRegistred;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Groupe getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User user = (User) obj;
			return Objects.equals(getFirstName(), user.getFirstName()) &&
				   Objects.equals(getLastName(), user.getLastName()) &&
				   Objects.equals(getDateRegistred(), user.getDateRegistred()) &&
				   Objects.equals(getUserName(), user.getUserName()) &&
				   Objects.equals(getPassword(), user.getPassword()) &&
				   Objects.equals(getTitle(), user.getTitle()) &&
				   Objects.equals(getPhone(), user.getPhone()) &&
				   Objects.equals(getEmployee(), user.getEmployee()) &&
				   Objects.equals(getGroupe(), user.getGroupe()) &&
				   Objects.equals(isEnabled(), user.isEnabled()) &&
				   Objects.equals(getLng(), user.getLng());
			
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getFirstName() , getLastName() , getDateRegistred() , getUserName() ,
				getPassword() , getTitle() , getPhone() , getEmployee() , getGroupe() , isEnabled() , getLng());
	}
	
}
