package EmployeeData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Employee {

	private static Connection con;
	private static PreparedStatement ps;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\n   ********** Welcome To Employee Management App **************\n");

		while (true) {
			System.out.println("1. Insert Employee Data                        Press  1");
			System.out.println("2. Delete Employee Data                      Press  2");
			System.out.println("3. Display Employee Data                     Press  3");
			System.out.println("4. Update Employee Data                     Press  4");
			System.out.println("5. Search Employee Data                      Press  5");
			System.out.println("6. Exit                                                      Press  6");

			System.out.println("\n Enter Your Choice");

			int ch = Integer.parseInt(br.readLine());

			switch (ch) {
			case 1:
				System.out.println("	Enter Employee Details :\n");
				System.out.println("Enter Employee First Name");
				String name = br.readLine();
				System.out.println("Enter Employee Surname");
				String surname = br.readLine();
				System.out.println("Enter Age of Employee");
				int age = Integer.parseInt(br.readLine());
				System.out.println("Enter Date of Birth");
				String dob = br.readLine();
				System.out.println("Enter Gender");
				String gender = br.readLine();
				System.out.println("Enter Contact no");
				String contact = br.readLine();
				System.out.println("Enter Year of Joining");
				int doj = Integer.parseInt(br.readLine());
				System.out.println("Enter Department ");
				String department = br.readLine();
				System.out.println("Enter Salary");
				float salary = Float.parseFloat(br.readLine());

				EmployeeData ed = new EmployeeData(name, surname, age, dob, gender, contact, doj, department, salary);
				boolean ans = EmployeeCon.InsertDB(ed);
				if (ans) {
					System.out.println("Employee Added Successfully ........\n");
				} else {
					System.out.println("Something Went Wrong ..........Try Again .....!!");
				}
				break;
			case 2:
				System.out.println("Enter employee name to DELETE record ");
				name = br.readLine();
				EmployeeCon.deleteDB(name);

				break;
			case 3:
				EmployeeCon.displayDB();
				System.out.println("");

				break;
			case 4:
				System.out.println("Enter employee name to UPDATE record ");
				name = br.readLine();
				EmployeeCon.updateDB(name);
				
				break;
			case 5:
				System.out.println("Search Employee by First Name ");
				String s = br.readLine();
				EmployeeCon.searchDB(s);

				break;
			case 6:
				System.out.println("<<<  Thank You >>>\n ");
				break;

			}
			if (ch == 6)
				break;
		}
	}

}
