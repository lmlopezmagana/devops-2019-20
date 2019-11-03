package com.salesianostriana.dam.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class NuevaVentaDto {
	
	private String nombre;
	@Builder.Default
	private List<NuevaLineaVentaDto> lineaVenta = new ArrayList<>();

}
