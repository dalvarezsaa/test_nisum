package com.test.nisum.enums;

import org.springframework.http.HttpStatus;

public enum TipoErrorEnum {

	MENSAJE_OK(HttpStatus.OK.value(), "OK"),
	MENSAJE_NO_UPDATE(0, "No se actualizaron registros"),
	MENSAJE_ERROR(0, "Error al actualizar usuario"),
	MENSAJE_ERROR_FORMATO(0, "Ha ocurrido un error en la aplicación, los parámetros no cumplen el formato.");
	
	private int codigo;
	private String nombre;
	
	
	private TipoErrorEnum(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

}
