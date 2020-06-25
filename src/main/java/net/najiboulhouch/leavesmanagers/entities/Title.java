package net.najiboulhouch.leavesmanagers.entities;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 1.0
 */
public enum Title {
	
	Mr("Mr") , Ms("Ms") , Dr("Dr") , Miss("Miss") ;
	private String code;

	private Title(String code) {
		this.code = code ;
	} 
	
	public String getLabel(){
		
		switch(this) {
		case Mr:
			return "Mr";
		case Ms:
			return "Ms";
		case Dr:
			return "Dr";
		case Miss:
			return "Miss";
		default :
			return null;
		}
	}

	public String getCode() {
		return code;
	}	

}
