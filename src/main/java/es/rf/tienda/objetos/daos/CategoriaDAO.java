package es.rf.tienda.objetos.daos;

import java.sql.ResultSet;

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
	
	
	public void listarCategorias() {
	/*	INSERT_1 = "INSERT INTO CATEGORIES VALUES('" + cat.getId_categoria() + "','" + cat.getCat_nombre()+ "','" + cat.getCat_descripcion() + "')";
		int filas = 0;
		try {
			filas = jdbc.ejecutar(SELECT_ALL_CATEGORIES);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Registros afectados: " + filas); */
		//return filas >  0  ;
	}
	
	public Categoria listarUnaCategoria(String values) {
		String[] attributes = values.split(";");
		
		String query = SELECT_ALL_CATEGORIES + " WHERE cat_id = " + attributes[0] + " AND CAT_NOMBRE = '" + attributes[1] + "' AND CAT_DESCRIPCION = '" + attributes[2] + "'";
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
