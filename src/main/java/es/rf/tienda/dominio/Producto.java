package es.rf.tienda.dominio;

import java.util.Calendar;
import java.util.Date;

public class Producto {
	private String id_producto;
	private String pro_descripcion;
	private String pro_desLarga;
	private Double pro_precio;
	private int pro_stock;
	private Calendar pro_fecRepos;
	private Calendar pro_fecActi;
	private Calendar pro_fecDesacti;
	private int pro_uniVenta;
	private int pro_cantXUniVenta;
	private String pro_uniUltNivel;
	private String id_pais;
	private String pro_usoRecomendado;
	private String id_categoria;
	private int pro_stkReservado;
	private int pro_nstkBajo;
	private int pro_nstkAlto;
	private String pro_state;
	
	public static final int PRO_ID_LONG_MIN = 5;
	public static final int PRO_ID_LONG_MAX = 5;
	
	public static final int PRO_DESCRIPCION_LONG_MIN = 5;
	public static final int PRO_DESCRIPCION_LONG_MAX = 100;
	public static final int PRO_DESCRIPCIONLARGA_LONG_MAX = 2000;
	
	public static final Double PRO_PRECIO__Min = 0.0;
	public static final Double PRO_PRECIO_MAX = 100.0;
	
	public static final int PRO_UNI_VENTA_Min = 1;
	public static final int PRO_UNI_VENTA_MAX = 10;
	
	public static final int PRO_STATE_LONG = 1;
	
	public Producto() {
		pro_desLarga = null;
		pro_stock = 0;
		pro_fecActi = null;
		pro_fecDesacti = null;
		pro_fecRepos = null;
		pro_cantXUniVenta = 0;
		pro_uniUltNivel = null;
		pro_usoRecomendado = null;
		pro_nstkAlto = 0;
		pro_nstkBajo = 0;
		pro_state = "A";
		
	}
	
	public String getId_producto() {
		return id_producto;
	}
	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}
	public String getPro_desCorta() {
		return pro_descripcion;
	}
	public void setPro_desCorta(String pro_desCorta) {
		this.pro_descripcion = pro_desCorta;
	}
	public String getPro_desLarga() {
		return pro_desLarga;
	}
	public void setPro_desLarga(String pro_desLarga) {
		this.pro_desLarga = pro_desLarga;
	}
	public Double getPro_precio() {
		return pro_precio;
	}
	public void setPro_precio(Double pro_precio) {
		this.pro_precio = pro_precio;
	}
	public int getPro_stock() {
		return pro_stock;
	}
	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}
	public Calendar getPro_fecRepos() {
		return pro_fecRepos;
	}
	public void setPro_fecRepos(Calendar pro_fecRepos) {
		this.pro_fecRepos = pro_fecRepos;
	}
	public Calendar getPro_fecActi() {
		return pro_fecActi;
	}
	public void setPro_fecActi(Calendar pro_fecActi) {
		this.pro_fecActi = pro_fecActi;
	}
	public Calendar getPro_fecDesacti() {
		return pro_fecDesacti;
	}
	public void setPro_fecDesacti(Calendar pro_fecDesacti) {
		this.pro_fecDesacti = pro_fecDesacti;
	}
	public int getPro_uniVenta() {
		return pro_uniVenta;
	}
	public void setPro_uniVenta(int pro_uniVenta) {
		this.pro_uniVenta = pro_uniVenta;
	}
	public int getPro_cantXUniVenta() {
		return pro_cantXUniVenta;
	}
	public void setPro_cantXUniVenta(int pro_cantXUniVenta) {
		this.pro_cantXUniVenta = pro_cantXUniVenta;
	}
	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}
	public void setPro_uniUltNivel(String pro_uniUltNivel) {
		this.pro_uniUltNivel = pro_uniUltNivel;
	}
	public String getId_pais() {
		return id_pais;
	}
	public void setId_pais(String id_pais) {
		this.id_pais = id_pais;
	}
	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}
	public void setPro_usoRecomendado(String pro_usoRecomendado) {
		this.pro_usoRecomendado = pro_usoRecomendado;
	}
	public String getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(String id_categoria) {
		this.id_categoria = id_categoria;
	}
	public int getPro_stkReservado() {
		return pro_stkReservado;
	}
	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}
	public int getPro_nstkBajo() {
		return pro_nstkBajo;
	}
	public void setPro_nstkBajo(int pro_nstkBajo) {
		this.pro_nstkBajo = pro_nstkBajo;
	}
	public int getPro_nstkAlto() {
		return pro_nstkAlto;
	}
	public void setPro_nstkAlto(int pro_nstkAlto) {
		this.pro_nstkAlto = pro_nstkAlto;
	}
	public String getPro_state() {
		return pro_state;
	}
	public void setPro_state(String pro_state) {
		this.pro_state = pro_state;
	}
	
	
}
