package com.bdm.classes;

public class Receptionist {
	private int empId;
	private String name;
	private String phoneNo;
	private String email;
	private String contry;
	private int bbNo;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public int getBbNo() {
		return bbNo;
	}

	public void setBbNo(int bbNo) {
		this.bbNo = bbNo;
	}

	@Override
	public String toString() {
		return "Receptionist [empId=" + empId + ", name=" + name + ", phoneNo=" + phoneNo + ", email=" + email
				+ ", contry=" + contry + ", bbNo=" + bbNo + "]";
	}

}
