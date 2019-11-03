package com.salesianostriana.dam.error;

public class VentaErroneaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4417398653075092560L;
	
	public VentaErroneaException() {
		super("No se puede crear una venta que no incluya líneas de venta");
	}

}
