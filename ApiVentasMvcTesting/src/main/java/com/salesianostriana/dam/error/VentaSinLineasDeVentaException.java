package com.salesianostriana.dam.error;

public class VentaSinLineasDeVentaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6485525362027193478L;

	
	public VentaSinLineasDeVentaException() {
		super("Se ha intentado crear una Venta sin Lineas de Venta");
	}
	
	

}
