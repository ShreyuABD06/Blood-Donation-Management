package com.bdm.dbutil;

import java.util.List;
import java.util.Scanner;

import com.bdm.classes.Blood;
import com.bdm.classes.BloodBank;
import com.bdm.classes.BloodBankManager;
import com.bdm.classes.Donor;
import com.bdm.classes.Hospital;
import com.bdm.classes.Receptionist;
import com.bdm.classes.SEX;
import com.bdm.classes.TYPE;
import com.bdm.classes.report.Report;

public class BloodDonationManagement {
	DBUtil db = new DBUtil();
	Scanner sc = new Scanner(System.in);

	public String addBloodBank(BloodBank i) {
		System.out.println("Enter BloodBank Name");
		String bbName = sc.next();
		i.setBbName(bbName);
		System.out.println("Enter City");
		String city = sc.next();
		i.setCity(city);
		System.out.println("Enter HospitalId");
		int hospitalId = sc.nextInt();
		i.setHospitalId(hospitalId);
		String s = db.addBloodBank(i);
		if (s != null) {
			System.out.println("BloodBank successfuly Added");
			return s;
		} else {
			return null;
		}
	}

	public List<BloodBank> getBloodBanks() {
		List<BloodBank> instList = db.getBloodBanks();
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public String addBlood(Blood prog) {
		System.out.println("Enter Blood Type: (A,B,O,AB)");
		TYPE type = TYPE.valueOf(sc.next());
		prog.setType(type);
		System.out.println("Enter Cost");
		Double cost = sc.nextDouble();
		prog.setCost(cost);
		System.out.println("Enter the BloodBank No");
		int bbNo = sc.nextInt();
		prog.setBbNo(bbNo);
		System.out.println("Enter the Donor Id");
		int donorId = sc.nextInt();
		prog.setDonorId(donorId);
		String s = db.addBlood(prog);
		if (s != null) {
			System.out.println("Blood successfuly Added");
			return s;
		} else {
			return null;
		}
	}

	public List<Blood> getBloodDonated() {
		List<Blood> instList = db.getBloodDonated();
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public Blood updateBloodCost(Blood updatedValue) {
		System.out.println("Enter Blood Code Updated");
		int bloodCode = sc.nextInt();
		updatedValue = getBloodCodeById(bloodCode);
		System.out.println("Enter the Cost of the Blood");
		Double cost = sc.nextDouble();
		updatedValue.setCost(cost);
		return updatedValue = db.updateBloodCost(updatedValue);
	}

	public Boolean registerDonor(Donor donor) {
		System.out.println("Enter the Donor Name");
		String name = sc.next();
		donor.setName(name);
		System.out.println("Enter Age");
		int age = sc.nextInt();
		donor.setAge(age);
		System.out.println("Enter City");
		String city = sc.next();
		donor.setCity(city);
		System.out.println("Enter Phone No");
		String phoneNo = sc.next();
		donor.setPhoneNo(phoneNo);
		System.out.println("Enter Sex:(M) or (F)");
		SEX sex = SEX.valueOf(sc.next());
		donor.setSex(sex);
		Boolean s = db.registerDonor(donor);
		if (s != null) {
			System.out.println("Donor successfuly Added");
			return s;
		} else {
			return null;
		}
	}

	public List<Donor> getDonors() {
		List<Donor> instList = db.getDonors();
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public Donor updateDonor(Donor updatedValue) {
		System.out.println("Enter Id of Donor to be Updated");
		int donorId = sc.nextInt();
		updatedValue = getDonorById(donorId);
		System.out.println("Enter the phoneno to be Updated");
		String phoneNo = sc.next();
		updatedValue.setPhoneNo(phoneNo);
		return updatedValue = db.updateDonor(updatedValue);
	}

	public String addHospital(Hospital hospital) {
		System.out.println("Enter Hospital Name");
		String hospitalName = sc.next();
		hospital.setHospitalName(hospitalName);
		System.out.println("Enter PhoneNo");
		String phoneNo = sc.next();
		hospital.setPhoneNo(phoneNo);
		System.out.println("Enter City");
		String city = sc.next();
		hospital.setCity(city);
		String s = db.addHospital(hospital);
		if (s != null) {
			System.out.println("Hospital successfuly Added");
			return s;
		} else {
			return null;
		}
	}

	public List<Hospital> getHospitals() {
		List<Hospital> instList = db.getHospitals();
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public Hospital updateHospital(Hospital updatedValue) {
		System.out.println("Enter Id of Hospital to be Updated");
		int Id = sc.nextInt();
		updatedValue = getHospitalId(Id);
		System.out.println("Enter the PhoneNo  to be Updated");
		String phoneNo = sc.next();
		updatedValue.setPhoneNo(phoneNo);
		return updatedValue = db.updateHospital(updatedValue);
	}

	public String addReceptionist(Receptionist receptionist) {
		System.out.println("Enter Receptionist Name");
		String name = sc.next();
		receptionist.setName(name);
		System.out.println("Enter PhoneNo");
		String phoneNo = sc.next();
		receptionist.setPhoneNo(phoneNo);
		System.out.println("Enter Email");
		String email = sc.next();
		receptionist.setEmail(email);
		System.out.println("Enter Country");
		String contry = sc.next();
		receptionist.setContry(contry);
		System.out.println("Enter BloodBank No");
		int bbNo = sc.nextInt();
		receptionist.setBbNo(bbNo);
		String s = db.addReceptionist(receptionist);
		if (s != null) {
			System.out.println("Receptionist successfuly Added");
			return s;
		} else {
			return null;
		}
	}

	public List<Receptionist> getReceptionists() {
		List<Receptionist> instList = db.getReceptionists();
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public Receptionist updateReceptionist(Receptionist updatedValue) {
		System.out.println("Enter Id of Receptionist to be Updated");
		int Id = sc.nextInt();
		updatedValue = getReceptionistById(Id);
		System.out.println("Enter the email to be Updated");
		String email = sc.next();
		updatedValue.setEmail(email);
		return updatedValue = db.updateReceptionist(updatedValue);
	}

	public String addBloodBankManager(BloodBankManager BloodBankManager) {
		System.out.println("Enter BloodBankManager Name");
		String name = sc.next();
		BloodBankManager.setName(name);
		System.out.println("Enter PhoneNo");
		String phoneNo = sc.next();
		BloodBankManager.setPhoneNo(phoneNo);
		System.out.println("Enter Email");
		String email = sc.next();
		BloodBankManager.setEmail(email);
		System.out.println("Enter Country");
		String contry = sc.next();
		BloodBankManager.setContry(contry);
		System.out.println("Enter BloodBank No");
		int bbNo = sc.nextInt();
		BloodBankManager.setBbNo(bbNo);
		String s = db.addBloodBankManager(BloodBankManager);
		if (s != null) {
			System.out.println("BloodBankManager successfuly Added");
			return s;
		} else {
			return null;
		}
	}

	public List<BloodBankManager> getBloodBankManagers() {
		List<BloodBankManager> instList = db.getBloodBankManagers();
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public BloodBankManager updateBloodBankManager(BloodBankManager updatedValue) {
		System.out.println("Enter Id of BloodBankManager to be Updated");
		int Id = sc.nextInt();
		updatedValue = getBloodBankManagerById(Id);
		System.out.println("Enter the email to be Updated");
		String email = sc.next();
		updatedValue.setEmail(email);
		return updatedValue = db.updateBloodBankManager(updatedValue);
	}

	private Blood getBloodCodeById(int bloodCode) {
		Blood stu = db.getBloodByBloodCode(bloodCode);
		if (stu != null) {
			return stu;
		} else {
			return null;
		}
	}

	public Donor getDonorById(int donorId) {
		Donor stu = db.getDonorById(donorId);
		if (stu != null) {
			return stu;
		} else {
			return null;
		}

	}

	public Hospital getHospitalId(int id) {
		Hospital stu = db.getHospitalById(id);
		if (stu != null) {
			return stu;
		} else {
			return null;
		}
	}

	public Receptionist getReceptionistById(int id) {
		Receptionist stu = db.getReceptionistById(id);
		if (stu != null) {
			return stu;
		} else {
			return null;
		}

	}

	public BloodBankManager getBloodBankManagerById(int id) {
		BloodBankManager stu = db.getBloodBankManagerById(id);
		if (stu != null) {
			return stu;
		} else {
			return null;
		}
	}

	public BloodBank getBloodBankById(int id) {
		BloodBank stu = db.getBloodBankById(id);
		if (stu != null) {
			return stu;
		} else {
			return null;
		}
	}
	public boolean validateAdmin(String username, String password){
		Boolean b=db.validateAdmin(username, password);	
		return b;		
	}
	public List<Report> getBloodDonationsReport() {
		List<Report> instList = db.getBloodDonationsReport();
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}
}
