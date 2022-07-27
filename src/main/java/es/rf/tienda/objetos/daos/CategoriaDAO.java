package es.rf.tienda.objetos.daos;

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
	//	String query = SELECT_ALL_CATEGORIES + " WHERE categoria_id = " + cat.getId_categoria() + " AND CATEGORIA_NOMBRE = " + cat.getCat_nombre()+ " AND CATEGORIA_DESCRIPCION = " + cat.getCat_descripcion();
	//	System.out.println(query);
		Categoria cat;
	
		
		return cat;
	}
}
