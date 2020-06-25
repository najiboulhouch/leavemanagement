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
@Table(name="TAB_RECOMMENDED_LEAVES")
public class RecommendedLeave extends BaseEntity  {

	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	private Employee employee ;
	
	@ManyToOne
	@JoinColumn(name="LEAVE_ID")
	private Leave leave ;
	
	@ManyToOne
	@JoinColumn(name="EMPL_RECOMMENDER_ID")
	private Employee recommendedBy;
	
	@Column(name="NUM_DAYS")
	private int numDays;
	
	@Column(name="WHY_RECOMMEND")
	private String whyRecommend;
	
	@Column(name="DATE_RECOMMENDED")
	@Type(type="date")
	private Date dateRecommended;
	
	@Column(name="STATUS")
	private Status status;
	
	public RecommendedLeave() {
		super();
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Leave getLeave() {
		return leave;
	}
	public void setLeave(Leave leave) {
		this.leave = leave;
	}
	public Employee getRecommendedBy() {
		return recommendedBy;
	}
	public void setRecommendedBy(Employee recommendedBy) {
		this.recommendedBy = recommendedBy;
	}
	public int getNumDays() {
		return numDays;
	}
	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}
	public String getWhyRecommend() {
		return whyRecommend;
	}
	public void setWhyRecommend(String whyRecommend) {
		this.whyRecommend = whyRecommend;
	}
	public Date getDateRecommended() {
		return dateRecommended;
	}
	public void setDateRecommended(Date dateRecommended) {
		this.dateRecommended = dateRecommended;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RecommendedLeave) {
			RecommendedLeave recommendedLeave = (RecommendedLeave) obj;
			return Objects.equals(getNumDays(), recommendedLeave.getNumDays()) &&
				   Objects.equals(getWhyRecommend(), recommendedLeave.getWhyRecommend()) &&
				   Objects.equals(getStatus(), recommendedLeave.getStatus()) &&
				   Objects.equals(getDateRecommended(), recommendedLeave.getDateRecommended());
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getNumDays() , getWhyRecommend() , getStatus() , getDateRecommended());
	}
	
}
