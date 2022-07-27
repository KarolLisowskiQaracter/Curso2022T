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
	
	public Categoria listOne(String cadena) {		
		return catDAO.listarUnaCategoria(cadena);
	}

	
	public List<Categoria> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Categoria> readSQL(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean crear(Categoria obj) {
			
		return catDAO.crearCategoria(obj);
	}

	
	public boolean actualizar(Categoria obj) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean borrar(Categoria obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
