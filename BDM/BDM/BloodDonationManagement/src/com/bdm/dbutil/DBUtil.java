package com.bdm.dbutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bdm.classes.Blood;
import com.bdm.classes.BloodBank;
import com.bdm.classes.BloodBankManager;
import com.bdm.classes.Donor;
import com.bdm.classes.Hospital;
import com.bdm.classes.Receptionist;
import com.bdm.classes.SEX;
import com.bdm.classes.TYPE;
import com.bdm.classes.report.Report;


public class DBUtil {
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	Statement stmt = null;

	private Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/blood";
		try {
			con = DriverManager.getConnection(url, "root", "mysql123");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return con;
	}

	public void close() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (pst != null)
			try {
				pst.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}

	}

	public String addBloodBank(BloodBank i) {
		try {
			con = getConnection();
			String query = "insert into bloodBank(bbName,city,hospitalId) values(?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, i.getBbName());
			pst.setString(2, i.getCity());
			pst.setInt(3, i.getHospitalId());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return i.getBbName();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public List<BloodBank> getBloodBanks() {
		BloodBank inst = null;
		List<BloodBank> bList = new ArrayList<BloodBank>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from bloodBank";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new BloodBank();
				inst.setBbNo(rs.getInt(1));
				inst.setBbName(rs.getString(2));
				inst.setCity(rs.getString(3));
				inst.setHospitalId(rs.getInt(5));
				bList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println("While Getting BloodBank " + e);
		} finally {
			close();
		}
		return bList;
	}

	public String addBlood(Blood prog) {
		try {
			con = getConnection();
			String s = "insert into blood(type,cost,bbNo,donorId)values(?,?,?,?)";
			pst = con.prepareStatement(s);
			pst.setString(1, prog.getType().name());
			pst.setDouble(2, prog.getCost());
			pst.setInt(3, prog.getBbNo());
			pst.setInt(4, prog.getDonorId());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return prog.getType().name();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public List<Blood> getBloodDonated() {
		Blood inst = null;
		List<Blood> instList = new ArrayList<Blood>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from Blood";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new Blood();
				inst.setBloodCode(rs.getInt(1));
				inst.setType(TYPE.valueOf(rs.getString(2)));
				inst.setCost(rs.getDouble(3));
				inst.setBbNo(rs.getInt(4));
				inst.setDonorId(rs.getInt(5));
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println("While Getting BloodDonated " + e);
		} finally {
			close();
		}
		return instList;
	}

	public Blood updateBloodCost(Blood updatedValue) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			String query = "update Blood set cost=? where bloodCode=?";
			pst = con.prepareStatement(query);
			pst.setDouble(1, updatedValue.getCost());
			pst.setInt(2, updatedValue.getBloodCode());
			pst.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return updatedValue;
	}

	public Boolean registerDonor(Donor donor) {
		try {
			con = getConnection();
			String query = "insert into donor(name,age,city,phoneNo,sex) values(?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, donor.getName());
			pst.setInt(2, donor.getAge());
			pst.setString(3, donor.getCity());
			pst.setString(4, donor.getPhoneNo());
			pst.setString(5, donor.getSex().name());
			
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return false;
	}

	public List<Donor> getDonors() {
		Donor inst = null;
		List<Donor> instList = new ArrayList<Donor>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from Donor";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new Donor();
				inst.setDonorId(rs.getInt(1));
				inst.setName(rs.getString(2));
				inst.setAge(rs.getInt(3));
				inst.setPhoneNo(rs.getString(4));
				inst.setSex(SEX.valueOf(rs.getString(5)));
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return instList;
	}

	public Donor updateDonor(Donor value) {
		try {
			con = getConnection();
			String query = "update Donor set phoneNo=? where donorId=?";
			pst = con.prepareStatement(query);
			pst.setString(1, value.getPhoneNo());
			pst.setInt(2, value.getDonorId());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return value;
	}

	public String addHospital(Hospital hospital) {
		try {
			con = getConnection();
			String query = "insert into hospital(hospitalName,city,phoneNo) values(?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, hospital.getHospitalName());
			pst.setString(2, hospital.getCity());
			pst.setString(3, hospital.getPhoneNo());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return hospital.getHospitalName();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public List<Hospital> getHospitals() {
		Hospital inst = null;
		List<Hospital> instList = new ArrayList<Hospital>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from Hospital";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new Hospital();
				inst.setHospitalId(rs.getInt(1));
				inst.setHospitalName(rs.getString(2));
				inst.setCity(rs.getString(3));
				inst.setPhoneNo(rs.getString(4));
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return instList;
	}

	public Hospital updateHospital(Hospital value) {
		try {
			con = getConnection();
			String query = "update Hospital set phoneNo=? where hospitalId=?";
			pst = con.prepareStatement(query);
			pst.setString(1, value.getPhoneNo());
			pst.setInt(2, value.getHospitalId());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return value;
	}

	public String addReceptionist(Receptionist receptionist) {
		try {
			con = getConnection();
			String query = "insert into receptionist(name,phoneNo,email,contry,bbNo) values(?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, receptionist.getName());
			pst.setString(2, receptionist.getPhoneNo());
			pst.setString(3, receptionist.getEmail());
			pst.setString(4, receptionist.getContry());
			pst.setInt(5, receptionist.getBbNo());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return receptionist.getName();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public List<Receptionist> getReceptionists() {
		Receptionist inst = null;
		List<Receptionist> instList = new ArrayList<Receptionist>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from Receptionist";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new Receptionist();
				inst.setEmpId(rs.getInt(1));
				inst.setName(rs.getString(2));
				inst.setPhoneNo(rs.getString(3));
				inst.setEmail(rs.getString(4));
				inst.setContry(rs.getString(5));
				inst.setBbNo(rs.getInt(6));
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return instList;
	}

	public Receptionist updateReceptionist(Receptionist value) {
		try {
			con = getConnection();
			String query = "update Receptionist set email=? where empId=?";
			pst = con.prepareStatement(query);
			pst.setString(1, value.getEmail());
			pst.setInt(2, value.getEmpId());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return value;
	}

	public String addBloodBankManager(BloodBankManager bloodbankmanager) {
		try {
			con = getConnection();
			String query = "insert into bloodbankmanager(name,phoneNo,email,contry,bbNo) values(?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, bloodbankmanager.getName());
			pst.setString(2, bloodbankmanager.getPhoneNo());
			pst.setString(3, bloodbankmanager.getEmail());
			pst.setString(4, bloodbankmanager.getContry());
			pst.setInt(5, bloodbankmanager.getBbNo());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return bloodbankmanager.getName();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public List<BloodBankManager> getBloodBankManagers() {
		BloodBankManager inst = null;
		List<BloodBankManager> instList = new ArrayList<BloodBankManager>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from BloodBankManager";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new BloodBankManager();
				inst.setEmpId(rs.getInt(1));
				inst.setName(rs.getString(2));
				inst.setPhoneNo(rs.getString(3));
				inst.setEmail(rs.getString(4));
				inst.setContry(rs.getString(5));
				inst.setBbNo(rs.getInt(6));
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return instList;
	}

	public BloodBankManager updateBloodBankManager(BloodBankManager value) {
		try {
			con = getConnection();
			String query = "update BloodBankManager set email=? where empId=?";
			pst = con.prepareStatement(query);
			pst.setString(1, value.getEmail());
			pst.setInt(2, value.getEmpId());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return value;
	}

	public BloodBank getBloodBankById(int bbNo) {
		BloodBank inst = null;
		try {
			con = getConnection();
			String sql = "select * from BloodBank where bbNo=" + bbNo;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				inst = new BloodBank();
				inst.setBbNo(rs.getInt(1));
				inst.setBbName(rs.getString(2));
				inst.setCity(rs.getString(3));
				inst.setHospitalId(rs.getInt(5));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return inst;
	}

	public Blood getBloodByBloodCode(int bCode) {
		Blood stu = null;
		try {
			con = getConnection();
			String sql = "select * from blood where bloodCode=" + bCode;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				stu = new Blood();
				stu.setBloodCode(rs.getInt(1));
				stu.setType(TYPE.valueOf(rs.getString(2)));
				stu.setCost(rs.getDouble(3));
				stu.setBbNo(rs.getInt(4));
				stu.setDonorId(rs.getInt(5));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return stu;
	}

	public Donor getDonorById(int hosId) {
		Donor c = null;
		try {
			con = getConnection();
			String sql = "select * from donor where donorId=" + hosId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				c = new Donor();
				c.setDonorId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setAge(rs.getInt(3));
				c.setPhoneNo(rs.getString(4));
				c.setSex(SEX.valueOf(rs.getString(5)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return c;
	}

	public Hospital getHospitalById(int instId) {
		Hospital inst = null;
		try {
			con = getConnection();
			String sql = "select * from hospital where hospitalId=" + instId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				inst = new Hospital();
				inst.setHospitalId(rs.getInt(1));
				inst.setHospitalName(rs.getString(2));
				inst.setCity(rs.getString(3));
				inst.setPhoneNo(rs.getString(4));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return inst;
	}

	public Receptionist getReceptionistById(int tId) {
		Receptionist stu = null;
		try {
			con = getConnection();
			String sql = "select * from receptionist where empId=" + tId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				stu = new Receptionist();
				stu.setEmpId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setPhoneNo(rs.getString(3));
				stu.setEmail(rs.getString(4));
				stu.setContry(rs.getString(5));
				stu.setBbNo(rs.getInt(6));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
			System.out.println("Connections Closed");
		}
		return stu;
	}

	public BloodBankManager getBloodBankManagerById(int bId) {
		BloodBankManager c = null;
		try {
			con = getConnection();
			String sql = "select * from BloodBankManager where empId=" + bId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				c = new BloodBankManager();
				c.setEmpId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPhoneNo(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setContry(rs.getString(5));
				c.setBbNo(rs.getInt(6));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return c;
	}
	public boolean validateAdmin(String username, String password) {
		con=getConnection();
		String sql="select * from admin where userName=? and password=? ";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs=pst.executeQuery();
			while(rs.next()) {
				return true;
			}
		}catch(SQLException s) {
			System.out.println(s.getMessage());
		}
		return false;
	}
	
	public List<Report> getBloodDonationsReport() {
		Report inst = null;
		List<Report> instList = new ArrayList<Report>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select d.name,b.type,bb.bbName,h.hospitalName,b.cost from blood b "
					+ "inner join donor d on b.donorId=d.donorId "
					+ "inner join bloodBank bb on b.bbNo=bb.bbNo "
					+ "inner join hospital h on bb.hospitalId=h.hospitalId";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new Report();
				inst.setName(rs.getString(1));
				inst.setType(TYPE.valueOf(rs.getString(2)));
				inst.setBbName(rs.getString(3));
				inst.setHospitalName(rs.getString(4));
				inst.setCost(rs.getDouble(5));
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return instList;
	}

}
