package net.najiboulhouch.leavesmanagers.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 */

@Entity
@Table(name="TAB_AUTHORITIES")
public class Authority  {
	
	@Id
	@Column(name="NAME")
	private String name;
	
	@Column(name="CODE")
	private String code;
	
	public Authority() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Authority){
			Authority authority = (Authority) obj;
			return Objects.equals(getCode(), authority.getCode());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getCode());
	}
	
}
