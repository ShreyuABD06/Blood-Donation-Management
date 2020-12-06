package com.bdm.classes.report;

import com.bdm.classes.TYPE;

public class Report {
private String name;
private TYPE type;
private String bbName;
private String hospitalName;
private double cost;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public TYPE getType() {
	return type;
}
public void setType(TYPE type) {
	this.type = type;
}
public String getBbName() {
	return bbName;
}
public void setBbName(String bbName) {
	this.bbName = bbName;
}
public String getHospitalName() {
	return hospitalName;
}
public void setHospitalName(String hospitalName) {
	this.hospitalName = hospitalName;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
@Override
public String toString() {
	return "Report [name=" + name + ", type=" + type + ", bbName=" + bbName + ", hospitalName=" + hospitalName
			+ ", cost=" + cost + "]";
}

}
