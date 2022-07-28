package es.rf.tienda.objetos.daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.OracleJDBC;

public class CategoriaDAO {
	OracleJDBC jdbc;
	private static String INSERT_1;
	private static String SELECT_ALL_CATEGORIES ="SELECT * FROM CATEGORIES";
	
	
	public CategoriaDAO() {
		jdbc = OracleJDBC.getInstance();
	}
	
	public boolean crearCategoria(Categoria cat) {
		INSERT_1 = "INSERT INTO CATEGORIES VALUES('" + cat.getId_categoria() + "','" + cat.getCat_nombre()+ "','" + cat.getCat_descripcion() + "')";
		int filas = 0;
		try {
			filas = jdbc.ejecutar(INSERT_1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Registros afectados: " + filas);
		return filas >  0  ;
	}
	
	
	public List<Categoria> listarCategorias() {
		ResultSet rs;
		List<Categoria> lista = new ArrayList<>();
		try {
			rs = jdbc.ejecutarQuery(SELECT_ALL_CATEGORIES);
			while (rs.next()) {
				  int id = rs.getInt("cat_id");
				  String nombre = rs.getString("cat_nombre");
				  String descripcion = rs.getString("cat_descripcion");
				  //Assuming you have a user object
				  Categoria cat = new Categoria(id, nombre, descripcion);
				  lista.add(cat);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Categoria listarUnaCategoria(Categoria categoria) {	
		String query = SELECT_ALL_CATEGORIES + " WHERE cat_id = " + categoria.getId_categoria() + " AND CAT_NOMBRE = '" + categoria.getCat_nombre() + "' AND CAT_DESCRIPCION = '" + categoria.getCat_descripcion() + "'";
		System.out.println(query);
		ResultSet rs;
		Categoria cat = new Categoria();
		try {
			rs = jdbc.ejecutarQuery(query);
			//cHECK IF CORRECT
			if(rs.next()) {
				cat.setId_categoria(rs.getInt(1));
				cat.setCat_nombre(rs.getString(2));
				cat.setCat_descripcion(rs.getString(3));
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cat;
	}
}
