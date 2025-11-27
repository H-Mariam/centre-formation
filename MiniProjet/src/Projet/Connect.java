package Projet;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver ok");
			String user="root";
			String pwd="";
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_formation",user,pwd);
			System.out.println("connected yes");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		return con;
	}

}
