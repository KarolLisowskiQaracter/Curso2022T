package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestValidator {

	static final String NOT_ALFANUMERIC = "jkhkhjk657675/&%/&%/?=)?)?cvx vcxcvxvc";
	static final String ALFANUMERIC = "poiuytre wqasdf . hhhhh áéíóúàèìò , ; -";
	static final String CODIGO_PRODUCTO_OK = "AB123";
	static final String CODIGO_PRODUCTO_NO1 = "A123B";
	static final String CODIGO_PRODUCTO_NO2 = "Ab123";
	static final String CODIGO_PRODUCTO_NO3 = "A0123";
	static final String CODIGO_PRODUCTO_FORMATO_ERR_NUM = "12345";
	static final String CODIGO_PRODUCTO_FORMATO_ERR_ALF = "ABCDE";
	static final String CODIGO_PRODUCTO_FORMATO_ERR_LON = "AB345678";
	static final String STRING_NULA = null;
	static final String STRING_VACIA = "";
	static final String CORREO_ELECTRONICO_CORRECTO = "migarcia@recursosformacion.com";
	static final String CORREO_ELECTRONICO_ERRONEO_1 = "migarcia.recursosformacion.com";
	static final String CORREO_ELECTRONICO_ERRONEO_2 = "migarcia@recursosformacion";
	
	static final String NUMERO_DNI_OK = "12.345.678-Z";
	static final String NUMERO_DNI_ERROR_LETRA = "12.345.678-A";
	static final String NUMERO_DNI_ERROR_FORM_CORTO = "12.2.678-A";
	static final String NUMERO_DNI_ERROR_FORM_CORTO2 = "122.678-A";
	static final String NUMERO_DNI_ERROR_FORM_LARGO = "123.456.678-A";
	static final String NUMERO_DNI_ERROR_FORM_ERR = "12345678A";
	static final String NUMERO_DNI_ERROR_FORM_ERR2 = "12.345.678.A";
	static final String CADENA1 = "a";
	static final String CADENA5 = "Ansde";
	static final String CADENA20 = "asmdjfoeirksndvieqaz";
	static final String CADENA30 = "qazxswedcvfrtgbnhyujm,kiol.-ñp";
	static final String CADENA50 = "poiuytrewqasdfghjklñmnbvcxzZXCVBNMÑLKJHGFDSAQWERTY";
	static final String PHONENUMBER = "1234567890";
	static final String PHONENUMBER_NO_VALIDO = "123456789g";
	static final String PASSWORD_VALIDA = "21389fDsif$";
	static final String PASSWORD_NO_VALIDA = "fiejvl3fufsojfioesjiofj34398ru893fjdsjfi2jijfidk";
	static final String FECHA_VALIDA = "29/11/1997";
	static final String FECHA_NO_VALIDA = "31/299/1997";
	
	static Calendar DIA_ANTERIOR;
	static Calendar DIA_POSTERIOR;
	
	/*static {
		Calendar DIA_ANTERIOR = Calendar.getInstance();
		DIA_ANTERIOR.set(1997, 11, 25);
		
		Calendar DIA_POSTERIOR = Calendar.getInstance();
		DIA_POSTERIOR.set(1997, 11, 31);
	} */
	
	@BeforeAll
	static void inicializar() {
		Calendar aux = Calendar.getInstance();
		aux.set(1997, 11, 25);
		DIA_ANTERIOR = aux;
		
		Calendar aux2 = Calendar.getInstance();
		aux2.set(1997, 11, 31);
		DIA_POSTERIOR = aux2;
	}
	
	@Test
	void testIsAlfanumeric() {
		assertAll(() -> assertTrue(Validator.isAlfanumeric(ALFANUMERIC)),
                () -> assertFalse(Validator.isAlfanumeric(NOT_ALFANUMERIC)));
	}
	
	@Test
	void testIsVacio() {
		assertAll(() -> assertTrue(Validator.isVacio(STRING_NULA)));
               // () -> assertTrue(Validator.isVacio(null)));
              //  () -> assertFalse(Validator.isVacio(CODIGO_PRODUCTO_OK)));
	}
	
	@Test
	void testCumplePhoneNumber() {
		assertAll(() -> assertTrue(Validator.cumplePhoneNumber(PHONENUMBER)),
                () -> assertFalse(Validator.cumplePhoneNumber(PHONENUMBER_NO_VALIDO)));
	}
	
	@Test
	void testIsEmailValido() {
		assertAll(() -> assertTrue(Validator.isEmailValido(CORREO_ELECTRONICO_CORRECTO)),
                () -> assertFalse(Validator.isEmailValido(CORREO_ELECTRONICO_ERRONEO_1)),
                () -> assertFalse(Validator.isEmailValido(CORREO_ELECTRONICO_ERRONEO_2)));
				
	}
	
	@Test
	void testCumpleDNI() {
		assertAll(() -> assertTrue(Validator.cumpleDNI(NUMERO_DNI_OK)),
                () -> assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_LETRA)),
				() -> assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_CORTO)),
				() -> assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_CORTO2)),
				() -> assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_LARGO)),
				() -> assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_ERR)),
				() -> assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_ERR2)));
	}
	
	
	@Test
	void testCumpleRangoIntIntInt() {
		assertAll(() -> assertTrue(Validator.cumpleRango(3,1,4)),
                () -> assertFalse(Validator.cumpleRango(5,6,10)));
	}
	
	@Test
	void testCumpleRangoDoubleIntInt() {
		assertAll(() -> assertTrue(Validator.cumpleRango(2.0,1,10)),
                () ->assertFalse(Validator.cumpleRango(2.0,0,1)));
	}
	
	@Test
	void testCumpleLongitudMin() {
		assertAll(() -> assertTrue(Validator.cumpleLongitudMin(CADENA1,1)),
                () -> assertFalse(Validator.cumpleLongitudMin(CADENA1,3)));
	}
	

	@Test
	void testCumpleLongitudMax() {
		assertAll(() ->assertTrue(Validator.cumpleLongitudMax(CADENA5,10)),
                () -> assertFalse(Validator.cumpleLongitudMax(CADENA30,25)));
	}

	
	@Test
	void testCumpleLongitud() {
		assertAll(() -> assertTrue(Validator.cumpleLongitud(CADENA50,1,100)),
                () -> assertFalse(Validator.cumpleLongitud(CADENA50,1,49)));
	}
	
	@Test
	void testValDateMin() {
		assertAll(() -> assertTrue(Validator.valDateMin(DIA_POSTERIOR,DIA_ANTERIOR)),
                () -> assertFalse(Validator.valDateMin(DIA_ANTERIOR,DIA_POSTERIOR)));
	}
	
	@Test
	void testValDateMax() {
		assertAll(() -> assertTrue(Validator.valDateMax(DIA_ANTERIOR,DIA_POSTERIOR)),
                () -> assertFalse(Validator.valDateMax(DIA_POSTERIOR,DIA_ANTERIOR)));	
	}
	
	@Test
	void testEsFechaValida() {
		assertAll(() -> assertTrue(Validator.esFechaValida(FECHA_VALIDA)),
                () -> assertFalse(Validator.esFechaValida(FECHA_NO_VALIDA)));
	}
	
	@Test
	void testEsPasswordValida() {
		assertAll(() -> assertTrue(Validator.esPasswordValida(PASSWORD_VALIDA)),
                () -> assertFalse(Validator.esPasswordValida(PASSWORD_NO_VALIDA)));	
	}

}
