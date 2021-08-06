package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utilities.JdbcConnection;

public class Education {
	public int eduid;
	public String course;
	public String university;
	public String place;
	public int marks;
	public int yop;
	public String department;

	Connection con = JdbcConnection.getConnection();
	ResultSet rs = null;
	PreparedStatement stmt = null;

	public int getEduId() {
		return eduid;
	}

	public void setEduid(int eduid) {
		this.eduid = eduid;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setEducationDetails() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		try {
			System.out.print("enter education id :");
			int eduid = sc.nextInt();
			setEduid(eduid);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}
		try {
			System.out.print("enter course :");
			String course = sc1.nextLine();
			setCourse(course);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}

		System.out.print("enter university :");
		String university = sc1.nextLine();

		System.out.print("enter place :");
		String place = sc1.nextLine();

		try {
			System.out.print("enter marks :");
			int marks = sc.nextInt();
			setMarks(marks);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}

		System.out.print("enter year of passing :");
		int yop = sc.nextInt();

		try {
			System.out.println("enter department :");
			String department = sc1.nextLine();
			setDepartment(department);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}

		try {
			stmt = con.prepareStatement("insert into education values(?,?,?,?,?,?,?)");
			stmt.setInt(1, eduid);
			stmt.setString(2, course);
			stmt.setString(3, university);
			stmt.setString(4, place);
			stmt.setInt(5, marks);
			stmt.setInt(6, yop);
			stmt.setString(7, department);
			stmt.executeUpdate();

			System.out.println("Values Inserted successfully in education");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getEducation() {

		try {

			String sql = "select * from education";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t"
						+ rs.getString(4) + "\t\t" + rs.getInt(5) + "\t\t" + rs.getInt(6) + "\t\t" + rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
