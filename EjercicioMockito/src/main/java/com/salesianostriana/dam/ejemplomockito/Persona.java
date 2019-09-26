package com.salesianostriana.dam.ejemplomockito;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Persona {
	
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;

}
