package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utilities.JdbcConnection;

public class Address {

	int addressid;
	String houseNo, street, locality, area, state, country;
	int pin;

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	Connection con = JdbcConnection.getConnection();
	ResultSet rs = null;
	PreparedStatement stmt = null;

	public void setAddress() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		try {
			System.out.print("enter addressid :");
			int addressid = sc.nextInt();
			setAddressid(addressid);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}
		try {
			System.out.print("enter houseno :");
			String houseNo = sc1.nextLine();
			setHouseNo(houseNo);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}
		
			System.out.print("enter street :");
			String street = sc1.nextLine();
			
			System.out.print("enter locality :");
			String locality = sc1.nextLine();
			
			System.out.print("enter area :");
			String area = sc1.nextLine();
		
		System.out.print("enter state :");
			String state = sc1.nextLine();
	
		try {
			System.out.print("enter country :");
			String country = sc1.nextLine();
			setCountry(country);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}
		try {
			System.out.print("enter pin :");
			int pin = sc.nextInt();
			setPin(pin);
		} catch (Exception e) {
			System.out.println("enter valid input");
		}

		try {
			stmt = con.prepareStatement("insert into address values(?,?,?,?,?,?,?,?)");
			stmt.setInt(1, addressid);
			stmt.setString(2, houseNo);
			stmt.setString(3, street);
			stmt.setString(4, locality);
			stmt.setString(5, area);
			stmt.setString(6, state);
			stmt.setString(7, country);
			stmt.setInt(8, pin);
			stmt.executeUpdate();

			System.out.println("Values Inserted successfully in address");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getAddress() {

		try {

			String sql = "select * from address";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t"
						+ rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t"
						+ rs.getString(7) + "\t\t" + rs.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
