package com.ts.dto;

public class Login {
private String LoginId;
private String Password;
public Login(){
	
}
public Login(String loginId, String password) {
	super();
	LoginId = loginId;
	Password = password;
}
public String getLoginId() {
	return LoginId;
}
public void setLoginId(String loginId) {
	LoginId = loginId;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}

}
