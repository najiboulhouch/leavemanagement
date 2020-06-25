package net.najiboulhouch.leavesmanagers.entities;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 20/12/2018
 *
 */
public enum LeaveType {
	ANNUAL_LEAVE(0) , 
	SICK_LEAVE(1) , 
	MATERNITY_LEAVE(2) , 
	PATERNITY_LEAVE(3) , 
	STUDY_LEAVE(4) , 
	EMERGENCY_LEAVE(5) ,
	CASUAL_LEAVE(6) ,
	SPECIAL_LEAVE(7) ,
	EXAMS_LEAVE(8) ,
	SPORTS_LEAVE(9) ,
	ABSCENCE_LEAVE(10) ,
	SHORT_EMBARK_DISEMBARK(11) ,
	LONG_EMBARK_DISEMBARK(12);
	
	private Integer id;
	
	private LeaveType(Integer id ) {
		this.id = id ;
	}	
	
	
	public String getLabel(){
		switch(this){
		case ANNUAL_LEAVE :
			return "Annual leave";
		case SICK_LEAVE : 
			return "Sick leave";
		case MATERNITY_LEAVE:
			return "Maternity leave";
		case PATERNITY_LEAVE :
			return "Paternity leave";
		case STUDY_LEAVE :
			return "Study leave";
		case EMERGENCY_LEAVE:
			return "Emergency leave";
		case CASUAL_LEAVE :	
			return "Casual leave";
		case SPECIAL_LEAVE:
			return "Special leave";
		case EXAMS_LEAVE:
			return "Exams leave";
		case SPORTS_LEAVE:
			return "Sports leave";
		case ABSCENCE_LEAVE:
			return "Abscence leave";
		case SHORT_EMBARK_DISEMBARK:
			return "Short embark disembark";
		case LONG_EMBARK_DISEMBARK:
			return "Long embark disembark";
		default :
			return null;
		}
	}
	
	public Integer getId() {
		return id;
	}
}
