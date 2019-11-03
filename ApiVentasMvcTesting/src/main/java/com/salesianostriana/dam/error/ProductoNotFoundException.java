package com.salesianostriana.dam.error;

public class ProductoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3217309174796191758L;
	
	
	public ProductoNotFoundException() {
		super("No se han encontrado productos");
	}
	
	public ProductoNotFoundException(Long id) {
		super("No se ha encontrado un Producto con ID: " + id);
	}
	

}
