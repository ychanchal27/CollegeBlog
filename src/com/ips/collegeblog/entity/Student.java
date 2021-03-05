package com.ips.collegeblog.entity;

public class Student {
	private Integer id;
	private String studentName;
	private String  studentEmail;
	private String contactNumber;
	private String password;
	
	public Student() {
		super();
	}
	public Student(Integer id, String studentName, String studentEmail, String contactNumber, String password) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.contactNumber = contactNumber;
		this.password = password;
	}
	public Student(String studentName, String studentEmail, String contactNumber, String password) {
		super();
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.contactNumber = contactNumber;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", contactNumber=" + contactNumber + ", password=" + password + "]";
	}
	
	

}
