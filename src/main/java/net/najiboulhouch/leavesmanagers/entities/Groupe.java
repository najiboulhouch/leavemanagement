package net.najiboulhouch.leavesmanagers.entities;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 20/12/2018
 */

@Entity
@Table(name = "TAB_GROUPES")
public class Groupe {

	@Id
	@Column(name = "NAME")
	private String name;

	@Column(name = "CODE")
	private String code;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "TAB_GROUPES_AUTHORITIES", joinColumns = { @JoinColumn(name = "GROUPE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "AUTHORITY_ID") })
	private Set<Authority> authorities;

	@OneToMany(mappedBy="groupe")
	private List<User> users;

	public Groupe() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Groupe){
			Groupe groupe = (Groupe) obj ;
			return Objects.equals(code, groupe.getCode());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

}
