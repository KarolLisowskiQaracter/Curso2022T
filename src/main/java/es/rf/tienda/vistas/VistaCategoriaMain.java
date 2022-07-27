package es.rf.tienda.vistas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VistaCategoriaMain {
	private final static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String DATABASE = "";
	private final static String USUARIO = "hr";
	private final static String PASSWORD = "hr";
	private final static String SQL_USE = "USE	";
	private final static String SQL_CREATE = "CREATE DATABASE ";
	
	
	public static void main(String[] args) {
		//private final Connection conn;
		
	
			
			try {
				Class.forName(JDBC_DRIVER);
			}catch(ClassNotFoundException e) {
				System.out.println("Where is your Oracle JDBC driver");
				e.printStackTrace();
				return;
			}
			
			System.out.println();
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(URL+DATABASE,USUARIO,PASSWORD);
			}catch(SQLException e) {
				System.out.println("Where is your Oracle JDBC driver");
				e.printStackTrace();
				return;
			}
			
			VistaMenu vista = new VistaMenu();
			vista.crearVistaMenu();
			
		/*	VistaCategoria vista = new VistaCategoria();
			vista.view(); */

	}

}
