package es.rf.tienda.objetos.daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.util.OracleJDBC;

public class UsuarioDAO {
	OracleJDBC jdbc;
	private static String INSERT_1;
	private static String UPDATE = "UPDATE USUARIO SET ";
	private static String SELECT_ALL_USUARIOS ="SELECT * FROM USUARIO";
	private static String DELETE ="DELETE FROM USUARIO ";
	
	
	public UsuarioDAO() {
		jdbc = OracleJDBC.getInstance();
	}
	
	public boolean crearUsuario(Usuario usuario) {
		INSERT_1 = "INSERT INTO USUARIO (ID_USUARIO,USER_NOMBRE,USER_EMAIL,USER_PASS, USER_DNI, ID_TIPO) VALUES(" + usuario.getId_usuario() + ",'" + usuario.getUser_nombre()+ "','" + usuario.getUser_email()
		+ "', '" + usuario.getUser_pass() + "', '" + usuario.getUser_dni() + "', " + usuario.getId_tipo() + ")";
		System.out.println(INSERT_1);
		int filas = 0;
		try {
			filas = jdbc.ejecutar(INSERT_1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Registros afectados: " + filas);
		return filas >  0  ;
	}
	
	
	public List<Usuario> listarUsuarios() {
		ResultSet rs;
		List<Usuario> lista = new ArrayList<>();
		try {
			rs = jdbc.ejecutarQuery(SELECT_ALL_USUARIOS);
			while (rs.next()) {
				  int id = rs.getInt("ID_USUARIO");
				  String nombre = rs.getString("User_nombre");
				  String email = rs.getString("User_email");
				  Usuario usuario = new Usuario(id, nombre, email);
				  lista.add(usuario);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Usuario listarUnUsuario(Usuario usuario) {	
		String query = SELECT_ALL_USUARIOS + " WHERE ID_USUARIO = " + usuario.getId_usuario() + " AND User_NOMBRE = '" + usuario.getUser_nombre() + "' AND User_email = '" + usuario.getUser_email() + "'";
		System.out.println(query);
		ResultSet rs;
		Usuario user = new Usuario();
		try {
			rs = jdbc.ejecutarQuery(query);
			if(rs.next()) {
				user.setId_usuario(rs.getInt(1));
				user.setUser_nombre(rs.getString(2));
				user.setUser_email(rs.getString(3));
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean actualizarUsuario(Usuario usuario) {	
		String query = UPDATE + "User_nombre = '" + usuario.getUser_nombre()+ "', " + " User_email = '" + usuario.getUser_email() + "', User_pass = '" + usuario.getUser_pass() + "', User_dni = '" + usuario.getUser_dni()
		+ "', ID_TIPO = " + usuario.getId_tipo() + " WHERE ID_USUARIO = " + usuario.getId_usuario();
		System.out.println(query);
		int filas = 0;
			try {
			filas = jdbc.ejecutar(query);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("Registros afectados: " + filas);
		return filas >  0  ;
	}
	
	
	public boolean borrarUsuario(Usuario usuario) {	
		String query = DELETE + "WHERE ID_USUARIO = " + usuario.getId_usuario();
		System.out.println(query);
		int filas = 0;
		try {
			filas = jdbc.ejecutar(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Registros afectados: " + filas);
		return filas >  0  ;
	}
	
	public void commit() {
		try {
			jdbc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
