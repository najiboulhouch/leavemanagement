package net.najiboulhouch.leavesmanagers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratePassword {
	
	public static void main(String[] args) {
		String encoded = new BCryptPasswordEncoder().encode("najib") ;
		boolean testMatching = new BCryptPasswordEncoder().matches("najib", "$2a$10$mCLd4FCSU1C8bFu.qW17EO/Do4Vbc8AsXzkwkzy1rtLBA/hiXdTjW") ;
		
		System.out.println(encoded + " " + testMatching);

	}

}
