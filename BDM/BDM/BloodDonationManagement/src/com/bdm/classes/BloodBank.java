package com.bdm.classes;

public class BloodBank {
	private int bbNo;
	private String bbName;
	private String city;
	private int hospitalId;

	public int getBbNo() {
		return bbNo;
	}

	public void setBbNo(int bbNo) {
		this.bbNo = bbNo;
	}

	public String getBbName() {
		return bbName;
	}

	public void setBbName(String bbName) {
		this.bbName = bbName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Override
	public String toString() {
		return "BloodBank [bbNo=" + bbNo + ", bbName=" + bbName + ", city=" + city + ", hospitalId=" + hospitalId + "]";
	}

}
