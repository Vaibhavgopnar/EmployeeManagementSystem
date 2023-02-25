package EmployeeData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlCon {

	static Connection con;
	public static Connection creatC()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/employee";
			String user = "root";
			String pass = "V2169@gpatil";

			con = DriverManager.getConnection(url,user,pass);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
}
