package com.ts.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

@XmlRootElement
@Entity
public class Passenger {
	@Id@GeneratedValue
	private int PassId;
	private String PassName;
	private String Gender;
	private int Age;
	private String Email;
	private String MobileNo;
	private String Address;
	private String LoginId;
	private String Password;
	private String ConfirmPassword;
	
	@OneToMany(mappedBy="passenger",fetch = FetchType.LAZY)
	
	@OneToOne(mappedBy="passenger",fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.JOIN)

	public int getPassId() {
		return PassId;
	}
	public void setPassId(int passId) {
		PassId = passId;
	}
	public String getPassName() {
		return PassName;
	}
	public void setPassName(String passName) {
		PassName = passName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
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
	
	public String getConfirmPassword() {
		return ConfirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}
	

}