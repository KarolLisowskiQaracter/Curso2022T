package es.rf.tienda.controladores;

import java.sql.ResultSet;
import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.objetos.daos.CategoriaDAO;
import es.rf.tienda.util.OracleJDBC;
import es.rf.tienda.vistas.VistaCategoria;

public class ControladorCategoria implements Controlador<Categoria>{
	private VistaCategoria vistaCat;
	private CategoriaDAO catDAO;
	
	public ControladorCategoria(VistaCategoria vista) {
		vistaCat = vista;
		catDAO = new CategoriaDAO();
		//jdbc = OracleJDBC.getInstance();
	}
	
	public Categoria listOne(Categoria categoria) {		
		return catDAO.listarUnaCategoria(categoria);
	}

	
	public List<Categoria> listAll() {
		return catDAO.listarCategorias();
	}

	
	public List<Categoria> readSQL(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean crear(Categoria obj) {
		Boolean result = catDAO.crearCategoria(obj);
		if(result) {
			catDAO.commit();
		} 
		return result;
	}

	
	public boolean actualizar(Categoria obj) {
		Boolean result = catDAO.actualizarCategoria(obj);
		if(result) {
			catDAO.commit();
		} 
		return result;
	}

	
	public boolean borrar(Categoria obj) {
		Boolean result = catDAO.borrarCategoria(obj);
		if(result) {
			catDAO.commit();
		} 
		return result;
	}

}
