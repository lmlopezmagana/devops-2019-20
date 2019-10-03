package com.salesianostriana.dam.ejemplomockito;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonaServicioImpl implements PersonaServicio {
	
	@NonNull
	private PersonaRepository personaRepository;
	
	
	@Override
	public List<Persona> mayoresDe40() {
		
		return personaRepository.findAll().stream()
				.filter(p -> ChronoUnit.YEARS.between(p.getFechaNacimiento(), LocalDate.now()) >= 40)
				.collect(Collectors.toList());
		
	}
	
	
	@Override
	public Set<String> nombresDiferentes() {
		return personaRepository.findAll().stream()
				.map(p -> p.getNombre())
				.distinct()
				.collect(Collectors.toSet());
	}
	

}
