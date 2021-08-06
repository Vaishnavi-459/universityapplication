package StudentPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utilities.JdbcConnection;
import utilities.Address;
import utilities.Education;

public class Students {
	public int stdid;
	public String stdname;
	public String stddob;
	public int stdpercentage;
	public int stdphy, stdche, stdmath;

	public int addressid;
	public int eduid;
	public int expid;

	Education studentEducation = new Education();
	Address studentAddress = new Address();

	Connection con = JdbcConnection.getConnection();
	ResultSet rs = null;
	PreparedStatement stmt = null;

	public int getStdId() {
		return stdid;
	}

	public void setStdId(int stdid) {
		this.stdid = stdid;
	}

	public String getStdName() {
		return stdname;
	}

	public void setStdName(String stdname) {
		this.stdname = stdname;
	}

	public String getStdDob() {
		return stddob;
	}

	public void setStdDob(String stddob) {
		this.stddob = stddob;
	}

	public int getStdPercentage() {
		return stdpercentage;
	}

	public void setStdPercentage(int stdpercentage) {
		this.stdpercentage = stdpercentage;
	}

	public int getStdPhy() {
		return stdphy;
	}

	public void setStdPhy(int stdphy) {
		this.stdphy = stdphy;
	}

	public int getStdChe() {
		return stdche;
	}

	public void setStdChe(int stdche) {
		this.stdche = stdche;
	}

	public int getStdMath() {
		return stdmath;
	}

	public void setStdMath(int stdmath) {
		this.stdmath = stdmath;
	}

	public Education getStudentEducation() {
		return studentEducation;
	}

	public void setStudentEducation(Education studentEducation) {
		this.studentEducation = studentEducation;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public void setStudentDetails() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		try {
			System.out.print("enter student id no :");
			int stdid = sc.nextInt();
			setStdId(stdid);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}
		try {
			System.out.print("enter Student name :");
			String stdname = sc1.nextLine();
			setStdName(stdname);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}

		System.out.print("enter student date of birth :");
		String stddob = sc1.nextLine();
		setStdDob(stddob);

		try {
			System.out.print("enter   percentage :");
			int stdpercentage = sc.nextInt();
			setStdPercentage(stdpercentage);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}

		System.out.print("enter  physics marks :");
		int stdphy = sc.nextInt();
		setStdPhy(stdphy);

		System.out.print("enter  chemistry marks :");
		int stdche = sc.nextInt();
		setStdChe(stdche);

		try {
			System.out.print("enter  maths marks:");
			int stdmath = sc.nextInt();
			setStdMath(stdmath);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}
		
		try {
			System.out.println(" Enter Student Education details :");
			studentEducation.setEducationDetails();
		} catch (Exception e) {
			System.out.println("enter valid input");
		}
		try {
			System.out.println("Student Address Details :");
			studentAddress.setAddress();
		} catch (Exception e) {
			System.out.println("enter valid input");
		}

		try {
			stmt = con.prepareStatement("insert into students values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, stdid);
			stmt.setString(2, stdname);
			stmt.setString(3, stddob);
			stmt.setInt(4, stdpercentage);
			stmt.setInt(5, stdphy);
			stmt.setInt(6, stdche);
			stmt.setInt(7, stdmath);

			stmt.setInt(8, addressid);
			stmt.setInt(9, eduid);
			stmt.setInt(10, expid);
			stmt.executeUpdate();
			System.out.println("Values Inserted successfully in student");
			
		} catch (SQLException se) {
			System.out.println("enter valid input:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getStudentDetails() {

		studentEducation.getEducation();
		studentAddress.getAddress();
		try {

			String sql = "select * from students";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t"
						+ rs.getInt(4) + "\t\t" + rs.getInt(5) + "\t\t" + rs.getInt(6) + "\t\t" + rs.getInt(7) + "\t\t"
						+ rs.getInt(8) + "\t\t" + rs.getInt(9) + "\t\t" + rs.getInt(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
