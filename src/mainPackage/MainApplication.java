package mainPackage;

import java.sql.SQLException;
import java.util.Scanner;

import employeePackage.Employee;
import StudentPackage.Students;

public class MainApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();
		Students student = new Students();
		int choice;

		do {

			System.out.println("University Details");
			System.out.println("Menu");
			System.out.println("enter 1  for display student details :");
			System.out.println("enter 2 for display Employee details :");
			System.out.println("enter 3 for number of students :");
			System.out.println("enter 4 for no of Employee details :");

			System.out.println("Please enter your choice:");

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("student details: ");
				student.getStudentDetails();
				break;

			case 2:
				System.out.println("Employee details:");
				employee.getEmployeeDetails();
				break;

			case 3:
				System.out.println("enter number of students:");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					try {
						student.setStudentDetails();
					} catch (SQLException e) {
						System.out.println("enter valid option");
					}
				}
				break;
			case 4:
				System.out.println("enter number of employees:");
				int n1 = sc.nextInt();

				for (int i = 0; i < n1; i++) {
					try {
						employee.setEmployeeDetails();
						employee.calculateSalary();
					} catch (Exception se) {
						System.out.println("enter valid option");
					}
				}
			default:
				System.out.println("Exit");
			}
		} while (choice <= 4);

	}
}
