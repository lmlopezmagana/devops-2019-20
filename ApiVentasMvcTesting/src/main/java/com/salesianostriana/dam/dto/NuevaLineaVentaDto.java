package com.salesianostriana.dam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class NuevaLineaVentaDto {

		@JsonProperty(value = "id_producto")
		private Long idProducto;
		private int cantidad;
	
}
