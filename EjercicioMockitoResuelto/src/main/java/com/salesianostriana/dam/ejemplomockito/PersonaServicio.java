package com.salesianostriana.dam.ejemplomockito;

import java.util.List;
import java.util.Set;

/**
 * Interfaz que ofrece servicios sobre un PersonaRepository
 * @author luismi
 *
 */
public interface PersonaServicio {

	/**
	 * 
	 * @return todas las personas del repositorio con más de 40 años
	 */
	List<Persona> mayoresDe40();

	/**
	 * 
	 * @return una colección de nombres diferentes como cadenas de caracteres
	 */
	Set<String> nombresDiferentes();

}