package es.rf.tienda.dominio;

import java.util.Calendar;
import java.util.Date;

public class Usuario {
	private int id_usuario;
	private String user_nombre;
	private String user_email;
	private String user_pass;
	private int id_tipo;
	private String user_dni;
	private Calendar user_fecAlta;
	private Calendar user_fecConfirmacion;
	
	public static final int USER_NOMBRE_LONG_MIN = 5;
	public static final int USER_NOMBRE_LONG_MAX = 100;
	
	public static final int USER_EMAIL_LONG_MIN = 6;
	public static final int USER_EMAIL_LONG_MAX = 100;
	
	public static final int USER_PASS_LONG_MIN = 8;
	public static final int USER_PASS_LONG_MAX = 20;
	
	public static final int USER_DNI_LONG = 12;
	
	public Usuario() {
		user_dni = null;
		user_fecAlta = null;
		user_fecConfirmacion = null;
	}
	
	public Usuario(int id, String nombre, String email) {
		id_usuario = id;
		user_nombre = nombre;
		user_email = email;
	} 
	
	public Usuario(int id, String nombre, String email, String contraseña, int tipoUsuario, String dni) {
		id_usuario = id;
		user_nombre = nombre;
		user_email = email;
		user_pass = contraseña;
		id_tipo = tipoUsuario;
		user_dni = dni;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getUser_nombre() {
		return user_nombre;
	}
	public void setUser_nombre(String user_nombre) {
		this.user_nombre = user_nombre;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	public String getUser_dni() {
		return user_dni;
	}
	public void setUser_dni(String user_dni) {
		this.user_dni = user_dni;
	}
	public Calendar getUser_fecAlta() {
		return user_fecAlta;
	}
	public void setUser_fecAlta(Calendar user_fecAlta) {
		this.user_fecAlta = user_fecAlta;
	}
	public Calendar getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}
	public void setUser_fecConfirmacion(Calendar user_fecConfirmacion) {
		this.user_fecConfirmacion = user_fecConfirmacion;
	}
	public String getUser_pago() {
		return user_pago;
	}
	public void setUser_pago(String user_pago) {
		this.user_pago = user_pago;
	}
	public String getUser_envio() {
		return user_envio;
	}
	public void setUser_envio(String user_envio) {
		this.user_envio = user_envio;
	}
	private String user_pago;
	private String user_envio;
	
	
}
