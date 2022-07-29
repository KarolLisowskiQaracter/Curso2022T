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
	private static String UPDATE = "UPDATE CATEGORIA SET ";
	private static String SELECT_ALL_CATEGORIA ="SELECT * FROM CATEGORIA";
	private static String DELETE ="DELETE FROM CATEGORIA ";
	
	
	public CategoriaDAO() {
		jdbc = OracleJDBC.getInstance();
	}
	
	public boolean crearCategoria(Categoria cat) {
		INSERT_1 = "INSERT INTO CATEGORIA VALUES('" + cat.getId_categoria() + "','" + cat.getCat_nombre()+ "','" + cat.getCat_descripcion() + "')";
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
			rs = jdbc.ejecutarQuery(SELECT_ALL_CATEGORIA);
			while (rs.next()) {
				  int id = rs.getInt("ID_CATEGORIA");
				  String nombre = rs.getString("cat_nombre");
				  String descripcion = rs.getString("cat_descripcion");
				  Categoria cat = new Categoria(id, nombre, descripcion);
				  lista.add(cat);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Categoria listarUnaCategoria(Categoria categoria) {	
		String query = SELECT_ALL_CATEGORIA + " WHERE ID_CATEGORIA = " + categoria.getId_categoria() + " AND CAT_NOMBRE = '" + categoria.getCat_nombre() + "' AND CAT_DESCRIPCION = '" + categoria.getCat_descripcion() + "'";
		System.out.println(query);
		ResultSet rs;
		Categoria cat = new Categoria();
		try {
			rs = jdbc.ejecutarQuery(query);
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
	
	public boolean actualizarCategoria(Categoria categoria) {	
		String query = UPDATE + "cat_nombre = '" + categoria.getCat_nombre()+ "', " + " cat_descripcion = '" + categoria.getCat_descripcion() +"' WHERE ID_CATEGORIA = " + categoria.getId_categoria();
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
	
	
	public boolean borrarCategoria(Categoria categoria) {	
		String query = DELETE + "WHERE ID_CATEGORIA = " + categoria.getId_categoria();
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
