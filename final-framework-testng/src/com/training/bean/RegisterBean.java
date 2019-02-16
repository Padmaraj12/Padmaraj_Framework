package com.training.bean;

public class RegisterBean {

	private String eMail;
	private String firstName;
	private String lastName;

	public RegisterBean() {
	}

	public RegisterBean(String eMail, String firstName, String lastName) {
		super();
		this.eMail = eMail;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "RegisterBean [eMail=" + eMail + ", firstName=" + firstName + ",lastName=" + lastName + "]";
	}

}

