package com.ips.collegeblog.entity;

public class College {

	private Integer id;
	private String collegeName;
	private String facultyName;
	private String emailAddress;
	private String password;
	
	
	
	public College() {
		super();
	}

	public College(String collegeName, String facultyName, String emailAddress, String password) {
		super();
		this.collegeName = collegeName;
		this.facultyName = facultyName;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public College(Integer id, String collegeName, String facultyName, String emailAddress, String password) {
		super();
		this.id = id;
		this.collegeName = collegeName;
		this.facultyName = facultyName;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public   String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public  String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", collegeName=" + collegeName + ", facultyName=" + facultyName + ", emailAddress="
				+ emailAddress + ", password=" + password + "]";
	}
	
	
}
