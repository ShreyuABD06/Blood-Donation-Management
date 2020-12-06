package com.bdm.classes;

public class Donor {
	private int donorId;
	private String name;
	private int age;
	private String city;
	private String phoneNo;
	private SEX sex;

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public SEX getSex() {
		return sex;
	}

	public void setSex(SEX sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", name=" + name + ", age=" + age + ", city=" + city + ", phoneNo="
				+ phoneNo + ", sex=" + sex + "]";
	}

}
