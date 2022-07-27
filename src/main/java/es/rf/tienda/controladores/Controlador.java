package es.rf.tienda.controladores;

import java.util.List;

public interface Controlador<T> {
	public T listOne(String s);
	public List<T> listAll();
	public List<T> readSQL(String query);
	public boolean crear(T obj);
	public boolean actualizar(T obj);
	public boolean borrar(T obj);
	
}
