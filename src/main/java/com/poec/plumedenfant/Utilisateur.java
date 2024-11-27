package com.poec.plumedenfant;

public class Utilisateur {
	
	String mail;
	String password;
	
	Utilisateur(String mail, String password){
		mail = this.mail;
		password = this.password;
	}
	
	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	private void checkRegEx(String str, String RegEx) {
		System.out.println(("checkRegEx"));
	}
	
	public boolean	checkMailValidity() {
//		checkRegEx("absc356@provider.com",".+@.+\\.[a-z]+");
		return true;
	}

	public boolean checkPassword() {
//		checkRegEx("absc35#Acom","^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
		return true;
	}
	
	public boolean checkMailNotNull() {
		return true;
	}
	
	public boolean checkPasswordNotNull() {
		return true;
	}
}
