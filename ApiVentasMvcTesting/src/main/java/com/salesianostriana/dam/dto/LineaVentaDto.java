package com.salesianostriana.dam.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class LineaVentaDto {

	private String producto;
	private float precioUnitario;
	private int cantidad;
	
	
}
