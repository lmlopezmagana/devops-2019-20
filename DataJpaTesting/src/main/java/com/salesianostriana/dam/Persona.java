package com.salesianostriana.dam;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Persona {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;

}
