package net.najiboulhouch.leavesmanagers.exceptions;

/**
 * 
 * @author n.oulhouch
 * @version 1.0
 * @since 20/12/2018
 * @see Exception
 */
public class ValidationException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String code;
	
	public ValidationException(String code) {
		super(code);
		this.code = code ;
	}
	
	public ValidationException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public ValidationException(String message, String code) {
		super(message);
		this.code = code;
	}

	public ValidationException(Throwable cause, String code) {
		super(cause);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return this.code ;
	}
	
	
	
}
