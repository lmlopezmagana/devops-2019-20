package com.salesianostriana.dam.EjemploMockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.salesianostriana.dam.ejemplomockito.Persona;
import com.salesianostriana.dam.ejemplomockito.PersonaRepository;
import com.salesianostriana.dam.ejemplomockito.PersonaServicio;

public class PersonaServicioTest {
	
	@InjectMocks
	private PersonaServicio servicio;
	
	@Mock
	private PersonaRepository repositorio;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	private static 	List<Persona> data = Arrays.asList(
			new Persona("Pepe","Perez", LocalDate.of(1940,1,1)),
			new Persona("Andrés", "Martínez", LocalDate.of(2000,1,1)));
 

	@Test
	public final void testMayoresDe40() {
		
		
		when(repositorio.findAll()).thenReturn(data);
		
		List<Persona> resultado = servicio.mayoresDe40();
		
		Persona persona = new Persona("Pepe", "Perez", LocalDate.of(1940, 1, 1));
		List<Persona> esperado = Arrays.asList(persona);
		
		
		assertEquals(esperado, resultado);
		
		
	}

	
	@Test
	public final void testNombresDiferentes() {
		
		when(repositorio.findAll()).thenReturn(data);
		
		Set<String> resultado = servicio.nombresDiferentes();
		
		Set<String> esperado = Set.of("Pepe", "Andrés");
		
		assertEquals(esperado, resultado);
		
		
		
		
	}

}
