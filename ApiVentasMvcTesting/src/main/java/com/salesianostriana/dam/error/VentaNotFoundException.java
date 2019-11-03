package com.salesianostriana.dam.error;

public class VentaNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3217309174796191758L;
	
	
	public VentaNotFoundException() {
		super("No se han encontrado ventas");
	}
	
	public VentaNotFoundException(Long id) {
		super("No se ha encontrado una Venta con ID: " + id);
	}
	

}
