package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utilities.JdbcConnection;

public class Experience {
	public int expid;
	public String organisationName;
	public String designation;
	public int exp;

	public Experience() {

	}

	public Experience(int expid, String organisationName, String designation, int experience) {
		this.expid = expid;
		this.organisationName = organisationName;
		this.designation = designation;
		this.exp = experience;
	}

	public int getExpid() {
		return expid;
	}

	public void setExpid(int expid) {
		this.expid = expid;
	}

	public String getOrganisationName() {

		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getDesignation() {

		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	Connection con = JdbcConnection.getConnection();
	ResultSet rs = null;
	PreparedStatement stmt = null;

	public void setExperience() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Please enter Experience Details :");
		System.out.println();
		try {
			System.out.print("enter experience id :");
			int expid = sc.nextInt();
			setExpid(expid);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}
		try {
			System.out.print("Enter organisationName :");
			String organisationName = sc1.nextLine();
			setOrganisationName(organisationName);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}

		System.out.print("Enter Designation :");
		String designation = sc1.nextLine();
		//setDesignation(designation);

		try {
			System.out.print("Enter employee experience :");
			int exp = sc.nextInt();
			setExp(exp);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}

		try {
			stmt = con.prepareStatement("insert into experience values(?,?,?,?)");
			stmt.setInt(1, expid);
			stmt.setString(2, organisationName);
			stmt.setString(3, designation);
			stmt.setInt(4, exp);
			stmt.executeUpdate();

			System.out.println("Values Inserted successfully in experience");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getExperience() {

		try {

			String sql = "select * from experience";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t" + rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
