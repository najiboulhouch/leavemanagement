package net.najiboulhouch.leavesmanagers.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 * @see BaseEntity
 */
@Entity
@Table(name="TAB_LEAVES_APPLICATIONS")
@AssociationOverrides({
	@AssociationOverride(name="primaryKey.leave" , joinColumns= @JoinColumn(name="LEAVE_ID")),
	@AssociationOverride(name="primaryKey.employee" , joinColumns= @JoinColumn(name="EMPL_ID")),	
})
public class LeaveApplication {

	@EmbeddedId
	private LeaveApplicationId primaryKey;
	
	@NotNull
	@Column(name="DATE_START_LEAVE")
	@Type(type="date")
	private Date dateStartLeave;
	
	@NotNull
	@Column(name="DATE_END_LEAVE")
	@Type(type="date")
	private Date dateEndLeave;
	
	@Column(name="STATUS")
	@Enumerated(EnumType.ORDINAL)
	private Status status ;
	
	@NotNull
	@Column(name="DATE_REQUESTED")
	@Type(type="date")
	private Date dateRequested;
	
	public LeaveApplication() {
		primaryKey = new LeaveApplicationId();
	}
	public LeaveApplicationId getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(LeaveApplicationId primaryKey) {
		this.primaryKey = primaryKey;
	}
	public Date getDateStartLeave() {
		return dateStartLeave;
	}
	public void setDateStartLeave(Date dateStartLeave) {
		this.dateStartLeave = dateStartLeave;
	}
	public Date getDateEndLeave() {
		return dateEndLeave;
	}
	public void setDateEndLeave(Date dateEndLeave) {
		this.dateEndLeave = dateEndLeave;
	}
	public Status getAction() {
		return status;
	}
	public void setAction(Status status) {
		this.status = status;
	}
	public Date getDateRequested() {
		return dateRequested;
	}
	public void setDateRequested(Date dateRequested) {
		this.dateRequested = dateRequested;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LeaveApplication) {
			LeaveApplication leaveApplication = (LeaveApplication) obj;
			return Objects.equals(getDateStartLeave(), leaveApplication.getDateStartLeave()) &&
				   Objects.equals(getDateEndLeave(), leaveApplication.getDateEndLeave()) &&
				   Objects.equals(getStatus(), leaveApplication.getStatus()) ;
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getDateStartLeave() , getDateEndLeave() , getStatus());
	}
}
