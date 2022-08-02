package es.rf.tienda.vistas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import es.rf.tienda.util.OracleJDBC;

public class VistaMain {
	
	public static void main(String[] args) {
		VistaMenu.getInstance();
	}

}
