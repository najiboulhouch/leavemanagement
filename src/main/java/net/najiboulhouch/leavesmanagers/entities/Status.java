package net.najiboulhouch.leavesmanagers.entities;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 */

public enum Status {
	ACCEPTED(0) , REJECTED(1) , PENDING(2);	
	private Integer id;
	
	private Status(Integer id ) {
		this.id = id ;
	}	
	
	public String getLabel(){
		switch(this){
		case ACCEPTED :
			return "Accepted";
		case REJECTED : 
			return "Rejected";
		case PENDING :
			return "Pending";
		default :
			return null;
		}
	}
	
	public Integer getId() {
		return id;
	}
	
}
