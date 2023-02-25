package EmployeeData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeCon {

	private static Connection con;
	private static PreparedStatement ps;
	private static ResultSet rs;

	public static boolean InsertDB(EmployeeData ed) {
		boolean f = false;
		try {

			con = SqlCon.creatC();
			String q = "Insert into employeedata(ID_No,Firstname,Surname,Age,DateofBirth,Gender,ContactNo,YearofJoining,Department,Salary) values(?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(q);

			ps.setInt(1, ed.getIdno());
			ps.setString(2, ed.getName());
			ps.setString(3, ed.getSurname());
			ps.setInt(4, ed.getAge());
			ps.setString(5, ed.getDob());
			ps.setString(6, ed.getGender());
			ps.setString(7, ed.getContact());
			ps.setInt(8, ed.getYoj());
			ps.setString(9, ed.getDepartment());
			ps.setFloat(10, ed.getSalary());

			ps.executeUpdate();
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

	@SuppressWarnings("resource")
	public static void deleteDB(String name) {
		try {
			Scanner sc = new Scanner(System.in);
			con = SqlCon.creatC();
			String q1 = "select * from employeedata where Firstname like '" + name + "%'";
			String q = "delete from employeedata where Firstname like'" + name + "%'";
			String q2 = "delete from employeedata where ID_No=?";

			ps = con.prepareStatement(q1);
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				System.out.println("*************************************************");
				System.out.println("ID no : " + rs.getInt(1));
				System.out.println("First Name : " + rs.getString(2));
				System.out.println("Surname : " + rs.getString(3));
				System.out.println("*************************************************");
				count++;
			}

			if (count == 1) {
				ps = con.prepareStatement(q);
				int s = ps.executeUpdate();
				if (s > 0) {
					System.out.println("Contact deleted successfully ........\n");
				}
			} else if (count > 1) {
				System.out.println("Enter Employee ID no To DELETE :");
				int id = sc.nextInt();
				ps = con.prepareStatement(q2);
				ps.setInt(1, id);
				int s = ps.executeUpdate();
				if (s > 0) {
					System.out.println("Contact deleted successfully .....");
				}
			} else {
				System.out.println("Record not Found ............!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void displayDB() {
		try {
			con = SqlCon.creatC();
			String q = "select * from employeedata;";

			Statement ps = con.createStatement();

			rs = ps.executeQuery(q);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String surname = rs.getString(3);
				int age = rs.getInt(4);
				String dob = rs.getString(5);
				String gender = rs.getString(6);
				int phone = rs.getInt(7);
				String yoj = rs.getString(8);
				String department = rs.getString(9);
				float salary = rs.getFloat(10);

				System.out.println("*************************************************");
				System.out.println("ID no : " + id);
				System.out.println("First Name : " + name);
				System.out.println("Surname : " + surname);
				System.out.println("Age : " + age);
				System.out.println("Date of Birth : " + dob);
				System.out.println("Gender : " + gender);
				System.out.println("Contact No : " + phone);
				System.out.println("Year of Joining : " + yoj);
				System.out.println("Department : " + department);
				System.out.println("Salary : " + salary);
				System.out.println("*************************************************\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchDB(String s) {
		try {
			con = SqlCon.creatC();
			String q = "select * from employeedata where Firstname like '" + s + "%'";

			ps = con.prepareStatement(q);
			rs = ps.executeQuery(q);
			int count = 0;
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String surname = rs.getString(3);
				int age = rs.getInt(4);
				String dob = rs.getString(5);
				String gender = rs.getString(6);
				int phone = rs.getInt(7);
				String yoj = rs.getString(8);
				String department = rs.getString(9);
				float salary = rs.getFloat(10);

				System.out.println("*************************************************");
				System.out.println("ID no : " + id);
				System.out.println("First Name : " + name);
				System.out.println("Surname : " + surname);
				System.out.println("Age : " + age);
				System.out.println("Date of Birth : " + dob);
				System.out.println("Gender : " + gender);
				System.out.println("Contact No : " + phone);
				System.out.println("Year of Joining : " + yoj);
				System.out.println("Department : " + department);
				System.out.println("Salary : " + salary);
				System.out.println("**************************************************\n");
				count++;
			}
			if (count == 0) {
				System.out.println("Record Not Found ..............!!\n");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void updateDB(String name) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		con = SqlCon.creatC();
		String q1 = "select * from employeedata where Firstname like '" + name + "%'";
		ps = con.prepareStatement(q1);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println("*************************************************");
			System.out.println("ID no : " + rs.getInt(1));
			System.out.println("First Name : " + rs.getString(2));
			System.out.println("Surname : " + rs.getString(3));
			System.out.println("*************************************************");
		}
		System.out.println("Enter Employee ID No To Update");
		int id1 = Integer.parseInt(br.readLine());

		while (true) {
			System.out.println("1.  FirstName");
			System.out.println("2.  Surname");
			System.out.println("3.  Age");
			System.out.println("4.  Date of Birth");
			System.out.println("5.  Gender");
			System.out.println("6.  Contact no");
			System.out.println("7.  Year of Joining");
			System.out.println("8.  Department");
			System.out.println("9.  Salary");
			System.out.println("10.Exit");

			System.out.println("\n What's To UPDATE");
			int ch = Integer.parseInt(br.readLine());

			switch (ch) {
			case 1:
				boolean f1 = false;
				try {
					System.out.println("Enter new First Name of Employee");
					String fn = br.readLine();

					con = SqlCon.creatC();
					String q = "update employeedata set FirstName=? where ID_no=?";

					ps = con.prepareStatement(q);
					ps.setString(1, fn);
					ps.setInt(2, id1);
					ps.executeUpdate();
					f1 = true;
					if (f1) {
						System.out.println("Successfully Updated ............!\n");
					} else {
						System.out.println("Something Went Wrong ...........!");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 2:
				boolean f2 = false;
				try {
					System.out.println("Enter new Surname Name of Employee");
					String fn = br.readLine();

					con = SqlCon.creatC();
					String q = "update employeedata set Surname=? where ID_no=?";

					ps = con.prepareStatement(q);
					ps.setString(1, fn);
					ps.setInt(2, id1);
					ps.executeUpdate();
					f2 = true;
					if (f2) {
						System.out.println("Successfully Updated ............!\n");
					} else {
						System.out.println("Something Went Wrong ...........!");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				boolean f3 = false;
				try {
					System.out.println("Enter new Age of Employee");
					int age = Integer.parseInt(br.readLine());

					con = SqlCon.creatC();
					String q = "update employeedata set Age=? where ID_no=?";

					ps = con.prepareStatement(q);
					ps.setInt(1, age);
					ps.setInt(2, id1);
					ps.executeUpdate();
					f3 = true;
					if (f3) {
						System.out.println("Successfully Updated ............!\n");
					} else {
						System.out.println("Something Went Wrong ...........!");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				boolean f4 = false;
				try {
					System.out.println("Enter new Date of Birth of Employee");
					String fn = br.readLine();

					con = SqlCon.creatC();
					String q = "update employeedata set DateofBirth=? where ID_no=?";

					ps = con.prepareStatement(q);
					ps.setString(1, fn);
					ps.setInt(2, id1);
					ps.executeUpdate();
					f4 = true;
					if (f4) {
						System.out.println("Successfully Updated ............!\n");
					} else {
						System.out.println("Something Went Wrong ...........!");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				boolean f5 = false;
				try {
					System.out.println("Enter new Gender of Employee");
					String fn = br.readLine();

					con = SqlCon.creatC();
					String q = "update employeedata set Gender=?where ID_no=?";

					ps = con.prepareStatement(q);
					ps.setString(1, fn);
					ps.setInt(2, id1);
					ps.executeUpdate();
					f5 = true;
					if (f5) {
						System.out.println("Successfully Updated ............!\n");
					} else {
						System.out.println("Something Went Wrong ...........!");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				boolean f6 = false;
				try {
					System.out.println("Enter new Contact No");
					int fn = Integer.parseInt(br.readLine());

					con = SqlCon.creatC();
					String q = "update employeedata set ContactNo=? where ID_no=?";

					ps = con.prepareStatement(q);
					ps.setInt(1, fn);
					ps.setInt(2, id1);
					ps.executeUpdate();
					f6 = true;
					if (f6) {
						System.out.println("Successfully Updated ............!\n");
					} else {
						System.out.println("Something Went Wrong ...........!");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 7:
				boolean f7 = false;
				try {
					System.out.println("Enter new Year of Jioning of Employee");
					int fn = Integer.parseInt(br.readLine());

					con = SqlCon.creatC();
					String q = "update employeedata set YearofJoining=?where ID_no=?";

					ps = con.prepareStatement(q);
					ps.setInt(1, fn);
					ps.setInt(2, id1);
					ps.executeUpdate();
					f7 = true;
					if (f7) {
						System.out.println("Successfully Updated ............!\n");
					} else {
						System.out.println("Something Went Wrong ...........!");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 8:
				boolean f8 = false;
				try {
					System.out.println("Enter new New Department of Employee");
					String fn = br.readLine();

					con = SqlCon.creatC();
					String q = "update employeedata set Department=?where ID_no=?";

					ps = con.prepareStatement(q);
					ps.setString(1, fn);
					ps.setInt(2, id1);
					ps.executeUpdate();
					f8 = true;
					if (f8) {
						System.out.println("Successfully Updated ............!\n");
					} else {
						System.out.println("Something Went Wrong ...........!");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 9:
				boolean f9 = false;
				try {
					System.out.println("Enter new Salary of Employee");
					float fn = Float.parseFloat(br.readLine());

					con = SqlCon.creatC();
					String q = "update employeedata set salary=?where ID_no=?";

					ps = con.prepareStatement(q);
					ps.setFloat(1, fn);
					ps.setInt(2, id1);
					ps.executeUpdate();
					f9 = true;
					if (f9) {
						System.out.println("Successfully Updated ............!\n");
					} else {
						System.out.println("Something Went Wrong ...........!");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 10:
				break;
			}
			break;
		}
	}
}
