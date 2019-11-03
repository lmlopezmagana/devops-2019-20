package com.salesianostriana.dam.dto;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class VentaDto {
	
	private long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fecha;
	private String nombre;
	private float total;
	Set<LineaVentaDto> lineasDeVenta;

}
