package fr.afcepf.atod19.jspServlet.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilAtod {

	private String url = "jdbc:mysql://localhost:3306/miniBank";
	private String user = "root";
	private String mdp = "afcepf";
	private Connection cnx;
	
	
	public Connection connection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			cnx = DriverManager.getConnection(url, user, mdp);
			System.out.println("connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("planté");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("planté");
		}
		return cnx;
	}
}
