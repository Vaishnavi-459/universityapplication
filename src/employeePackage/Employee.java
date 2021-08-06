package employeePackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import utilities.JdbcConnection;
import utilities.Address;
import utilities.Education;
import utilities.Experience;

public class Employee {
	public int empid;
	public String empname;
	public double empsalary;
	public int empdoj;
	public String empdob;
	public String empdesignation;
	public double empbonus = 0;

	public int addressid;
	public int eduid;
	public int expid;

	Address empAddress = new Address();

	Experience empExperience = new Experience();
	Education empEducation = new Education();

	Connection con = JdbcConnection.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int getEmpId() {
		return empid;
	}

	public void setEmpId(int empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empname;
	}

	public void setEmptName(String empname) {
		this.empname = empname;
	}

	public double getEmpSalary() {
		return empsalary;
	}

	public void setEmpSalary(double empsalary) {
		this.empsalary = empsalary;
	}

	public int getEmpDoj() {
		return empdoj;
	}

	public void setEmpDoj(int empdoj) {
		this.empdoj = empdoj;
	}

	public String getEmpDob() {
		return empdob;
	}

	public void setEmpDob(String empdob) {
		this.empdob = empdob;
	}

	public String getEmpDesignation() {
		return empdesignation;
	}

	public void setempDesignation(String empdesignation) {
		this.empdesignation = empdesignation;
	}

	public double getEmpBonus() {
		return empbonus;
	}

	public void setEmpBonus(double empbonus) {
		this.empbonus = empbonus;
	}

	public int getAddressid() {
		return addressid;
	}

	public Address getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(Address empAddress) {
		this.empAddress = empAddress;
	}

	public Experience getEmpExperience() {
		return empExperience;
	}

	public void setEmpExperience(Experience empExperience) {
		this.empExperience = empExperience;
	}

	public Education getEmpEducation() {
		return empEducation;
	}

	public void setEmpEducation(Education empEducation) {
		this.empEducation = empEducation;
	}

	public void setEmployeeDetails() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		try {
			System.out.print("Enter Employee ID :");
			int empid = sc.nextInt();
			setEmpId(empid);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}
		try {
			System.out.print("Enter Employee Name :");
			String empname = sc1.nextLine();
			setEmptName(empname);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}
		try {
			System.out.print("Enter Employee salary :");
			int empsalary = sc.nextInt();
			setEmpSalary(empsalary);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}

		System.out.print("Enter date of joining year :");
		int empdoj = sc.nextInt();

		try {
			System.out.print("Enter dob :");
			String empdob = sc1.nextLine();
			setEmpDob(empdob);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}
		try {
			System.out.print("Enter designation :");
			String empdesignation = sc1.nextLine();
			setempDesignation(empdesignation);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}
		try {
			System.out.print("Enter bonus :");
			double empbonus = sc2.nextDouble();
			setEmpBonus(empbonus);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}
		
		System.out.println("Enter Employee Education details :");
		empEducation.setEducationDetails();

		System.out.println("Enter Employee Address details :");
		empAddress.setAddress();

		System.out.println("Enter Employee Experience details :");
		empExperience.setExperience();

		try {
			ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, empid);
			ps.setString(2, empname);
			ps.setDouble(3, empsalary);
			ps.setInt(4, empdoj);
			ps.setString(5, empdob);
			ps.setString(6, empdesignation);
			ps.setDouble(7, empbonus);

			ps.setInt(8, addressid);
			ps.setInt(9, eduid);
			ps.setInt(10, expid);
			ps.executeUpdate();

			System.out.println("Values Inserted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void calculateSalary() {
		if (empsalary < 10000) {
			empbonus = empsalary * 20 / 100;
		}
	}

	public void getEmployeeDetails() {

		empEducation.getEducation();

		empAddress.getAddress();

		empExperience.getExperience();
		try {

			String sql = "select * from employee";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			// ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getDouble(3) + "\t\t"
						+ rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t"
						+ rs.getDouble(7) + "\t\t" + rs.getInt(8) + "\t\t" + rs.getInt(9) + "\t\t" + rs.getInt(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
