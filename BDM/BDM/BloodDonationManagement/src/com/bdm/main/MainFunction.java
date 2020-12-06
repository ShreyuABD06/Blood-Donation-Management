package com.bdm.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bdm.classes.Blood;
import com.bdm.classes.BloodBank;
import com.bdm.classes.BloodBankManager;
import com.bdm.classes.Donor;
import com.bdm.classes.Hospital;
import com.bdm.classes.Receptionist;
import com.bdm.classes.report.Report;
import com.bdm.dbutil.BloodDonationManagement;

public class MainFunction {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MainFunction s = new MainFunction();
		s.begin();
	}

	private void begin() {
		try {
			{
				System.out.println("1:Blood Bank Management");
				System.out.println("2:Recepitionist");
				System.out.println("3:Donor");
				System.out.println("3:Exit");
				Scanner sc = new Scanner(System.in);
				BloodDonationManagement c = new BloodDonationManagement();
				System.out.println("Enter your choice");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter your E-mail :");// Create table
																// for
																// admin with
																// only 1
																// admin in db
					String username = sc.next();
					System.out.println("Enter your Password :");
					String password = sc.next();
					boolean check = c.validateAdmin(username, password);
					if (check) {

						System.out.println("Welcome Admin");
						System.out.println("1:Add Hospital");
						System.out.println("2:Add Blood Bank");
						System.out.println("3:Add Blood Bank Manager");
						System.out.println("4:Add Receptionist");
						System.out.println("5:Update Blood Bank Manager(Email)");
						System.out.println("6:update Hospital(phoneNo)");
						System.out.println("7:Update receptionist(email)");
						System.out.println("8:View Receptionist Details");
						System.out.println("9:View Hospital Details");
						System.out.println("10:View Manager Details");
						System.out.println("11:View Blood Bank Details");
						System.out.println("12:Report Blood Donations(DONOR,BLOOD TYPE,BLOODBANK,HOSPITAL");
						System.out.println("13:Exit");
						System.out.println("Enter your choice");
						int choice1 = sc.nextInt();
						adminTasks(choice1);
					} else {
						System.out.println("Invalid Credentials");
					}

					break;

				case 2:// Receptionist
					System.out.println("What do you Wish To Do Receptionist.....");
					System.out.println("1:Register Donor and Add Blood Donated(Register Before Donation)");
					System.out.println("2;Update Donor");
					System.out.println("3:Update Blood donated Cost");
					System.out.println("4:View All Blood Donations");
					System.out.println("5:View Donors");
					System.out.println("6:Exit");
					System.out.println("Enter your choice");
					int choice2 = sc.nextInt();
					receptionistTasks(choice2);
					break;
				case 3:// Donor
					System.out.println("View Hospitals");
					System.out.println("View Blood Banks");
					System.out.println("View all Blood Donations");
					System.out.println("Enter your choice");
					int choice3 = sc.nextInt();
					donorOptions(choice3);
					break;
				case 4:
					System.out.println("Thank You");
					System.exit(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void donorOptions(int choice3) {
		BloodDonationManagement c = new BloodDonationManagement();
		switch (choice3) {
		case 1:

			List<Hospital> list = c.getHospitals();
			System.out.println("Please wait    Loading Hospitals ");
			if (list != null) {
				System.out.println("....Hospitals....");
				System.out.println("*******************");
				Iterator<Hospital> itr = list.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
			} else {
				System.out.println("No Hospitals");
			}
			break;
		case 2:
			List<BloodBank> list1 = c.getBloodBanks();
			System.out.println("Please wait    Loading Blood Banks ");
			if (list1 != null) {
				System.out.println("....Blood Banks....");
				System.out.println("*******************");
				Iterator<BloodBank> itr = list1.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
			} else {
				System.out.println("No Blood Banks");
			}
			break;
		case 3:
			List<Blood> list2 = c.getBloodDonated();
			System.out.println("Please wait    Loading All Blood Donations ");
			if (list2 != null) {
				System.out.println("....Blood Banks....");
				System.out.println("*******************");
				Iterator<Blood> itr = list2.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
			} else {
				System.out.println("No Blood Donations");
			}
			break;
		}

	}

	private void receptionistTasks(int choice2) {
		BloodDonationManagement c = new BloodDonationManagement();
		switch (choice2) {
		case 1:
			Donor donor = new Donor();
			Boolean s = c.registerDonor(donor);
			System.out.println("Please wait .......................... ");
			if (s) {
				System.out.println("Registered Donor Successfully");
				System.out.println("Please Add To A Blood Bank");
				Blood blood = new Blood();
				String s1 = c.addBlood(blood);

				if (s1 != null) {
					System.out.println("Blood Type= " + s1);
				} else {
					System.out.println("Blood could nOt Be Transfered To Blood Bank");
					System.out.println("Check The Problem And transfer");
					System.out.println("Dont Waste Blood ......It's Precious");
				}
			} else {
				System.out.println("Could Nt Register Donor");
			}
			break;
		case 2:
			Donor i1 = new Donor();
			i1 = c.updateDonor(i1);
			System.out.println("Please wait .......................... ");
			System.out.println("After Update");
			System.out.println(i1);
			break;
		case 3:
			Blood i2 = new Blood();
			i2 = c.updateBloodCost(i2);
			System.out.println("Please wait .......................... ");
			System.out.println("After Update");
			System.out.println(i2);
			break;
		case 4:
			List<Blood> list2 = c.getBloodDonated();
			System.out.println("Please wait    Loading All Blood Donations ");
			if (list2 != null) {
				System.out.println("....Blood Banks....");
				System.out.println("*******************");
				Iterator<Blood> itr = list2.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
			} else {
				System.out.println("No Blood Donations");
			}
			break;
		case 5:
			List<Donor> list3 = c.getDonors();
			System.out.println("Please wait    Loading All Donors ");
			if (list3 != null) {
				System.out.println("....Donors....");
				System.out.println("*******************");
				Iterator<Donor> itr = list3.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
			} else {
				System.out.println("No DOnors");
			}
			break;
		case 6:
			System.out.println("Thank You");
			break;
		}
	}

	private void adminTasks(int choice1) {
		BloodDonationManagement c = new BloodDonationManagement();
		switch (choice1) {
		case 1:
			Hospital hospital = new Hospital();
			String s2 = c.addHospital(hospital);
			System.out.println("Please wait .......................... ");
			if (s2 != null) {
				System.out.println("Hospital : " + s2);
			} else {
				System.out.println("Hospital could nOt Be Added");
			}
			break;

		case 2:
			BloodBank b1 = new BloodBank();
			String s1 = c.addBloodBank(b1);
			System.out.println("Please wait .......................... ");
			if (s1 != null) {
				System.out.println("Blood Bank : " + s1);
			} else {
				System.out.println("Blood Bank  could nOt Be Added");
			}
			break;
		case 3:

			BloodBankManager b = new BloodBankManager();
			String s = c.addBloodBankManager(b);
			System.out.println("Please wait .......................... ");
			if (s != null) {
				System.out.println("Blood Bank Manager : " + s);
			} else {
				System.out.println("Blood Bank Manager could nOt Be Added");
			}
			break;
		case 4:
			Receptionist receptionist = new Receptionist();
			String s3 = c.addReceptionist(receptionist);
			System.out.println("Please wait .......................... ");
			if (s3 != null) {
				System.out.println("Receptionist : " + s3);
			} else {
				System.out.println("Receptionist could nOt Be Added");
			}
			break;
		case 5:
			BloodBankManager i1 = new BloodBankManager();
			i1 = c.updateBloodBankManager(i1);
			System.out.println("Please wait .......................... ");
			System.out.println("After Update");
			System.out.println(i1);
			break;
		case 6:
			Hospital i2 = new Hospital();
			i2 = c.updateHospital(i2);
			System.out.println("Please wait .......................... ");
			System.out.println("After Update");
			System.out.println(i2);
			break;

		case 7:
			Receptionist i3 = new Receptionist();
			i3 = c.updateReceptionist(i3);
			System.out.println("Please wait .......................... ");
			System.out.println("After Update");
			System.out.println(i3);
			break;
		case 8:
			List<Receptionist> list3 = c.getReceptionists();
			System.out.println("Please wait    Loading Receptionists ");
			if (list3 != null) {
				System.out.println("....Receptionists....");
				System.out.println("*******************");
				Iterator<Receptionist> itr = list3.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
			} else {
				System.out.println("No Receptionists");
			}
			break;

		case 9:
			List<Hospital> list = c.getHospitals();
			System.out.println("Please wait    Loading Hospitals ");
			if (list != null) {
				System.out.println("....Hospitals....");
				System.out.println("*******************");
				Iterator<Hospital> itr = list.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
			} else {
				System.out.println("No Hospitals");
			}
			break;
		case 10:
			List<BloodBankManager> list2 = c.getBloodBankManagers();
			System.out.println("Please wait    Loading Blood Bank Manager ");
			if (list2 != null) {
				System.out.println("....Blood Bank Manager....");
				System.out.println("*******************");
				Iterator<BloodBankManager> itr = list2.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
			} else {
				System.out.println("No Blood Bank Manager");
			}
			break;

		case 11:
			List<BloodBank> list1 = c.getBloodBanks();
			System.out.println("Please wait    Loading Blood Banks ");
			if (list1 != null) {
				System.out.println("....Blood Banks....");
				System.out.println("*******************");
				Iterator<BloodBank> itr = list1.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
			} else {
				System.out.println("No Blood Banks");
			}
			break;
		case 12:
			List<Report> list5 = c.getBloodDonationsReport();
			System.out.println("Please wait    Loading Blood Donations Report ");
			if (list5 != null) {
				System.out.println("....Blood Donations....");
				System.out.println("*******************");
				Iterator<Report> itr = list5.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
			} else {
				System.out.println("No Blood Donations");
			}
			break;
		}

	}
}
