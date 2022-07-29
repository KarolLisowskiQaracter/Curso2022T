package es.rf.tienda.controladores;

import java.util.List;

import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.objetos.daos.CategoriaDAO;
import es.rf.tienda.objetos.daos.UsuarioDAO;
import es.rf.tienda.vistas.VistaCategoria;
import es.rf.tienda.vistas.VistaUsuario;

public class ControladorUsuario implements Controlador<Usuario>{
	private VistaUsuario vistaUsuario;
	private UsuarioDAO usuarioDAO;
	
	public ControladorUsuario(VistaUsuario vista) {
		vistaUsuario = vista;
		usuarioDAO = new UsuarioDAO();
		//jdbc = OracleJDBC.getInstance();
	}
	
	public Usuario listOne(Usuario user) {
		return usuarioDAO.listarUnUsuario(user);
	}

	public List<Usuario> listAll() {
		return usuarioDAO.listarUsuarios();
	}

	public List<Usuario> readSQL(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean crear(Usuario user) {
		Boolean result = usuarioDAO.actualizarUsuario(user);
		if(result) {
			usuarioDAO.commit();
		} 
		return result;
	}

	public boolean actualizar(Usuario user) {
		Boolean result = usuarioDAO.actualizarUsuario(user);
		if(result) {
			usuarioDAO.commit();
		} 
		return result;
	}

	public boolean borrar(Usuario user) {
		Boolean result = usuarioDAO.actualizarUsuario(user);
		if(result) {
			usuarioDAO.commit();
		}
		return result;
	}

}
