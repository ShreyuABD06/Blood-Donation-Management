package com.bdm.classes;

public class Blood {
	private int bloodCode;
	private TYPE type;
	private double cost;
	private int bbNo;
	private int donorId;

	public int getBloodCode() {
		return bloodCode;
	}

	public void setBloodCode(int bloodCode) {
		this.bloodCode = bloodCode;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getBbNo() {
		return bbNo;
	}

	public void setBbNo(int bbNo) {
		this.bbNo = bbNo;
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	@Override
	public String toString() {
		return "Blood [bloodCode=" + bloodCode + ", type=" + type + ", cost=" + cost + ", bbNo=" + bbNo + ", donorId="
				+ donorId + "]";
	}

}
