package com.salesianostriana.dam.ejemplomockito;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaRepository {

	private String data = "IGNACIO,HIDALGO,07/09/1958\n" + 
			"JOSE MARIA,FERNANDEZ,02/12/1984\n" + 
			"ROSA MARIA,MOLINA,04/06/1959\n" + 
			"ALFONSO,VARGAS,13/12/1957\n" + 
			"RICARDO,DIEZ,18/04/1960\n" + 
			"LORENA,ALONSO,13/10/1961\n" + 
			"LUIS,GUERRERO,05/08/1992\n" + 
			"ESTHER,DOMINGUEZ,10/10/1960\n" + 
			"RICARDO,MARTINEZ,24/10/1957\n" + 
			"ROSA,VIDAL,10/04/1956\n" + 
			"ROSA MARIA,GONZALEZ,11/06/1967\n" + 
			"IRENE,PEÑA,19/03/1966\n" + 
			"ALEJANDRA,ROMERO,05/12/1995\n" + 
			"MARIA MERCEDES,CRUZ,10/04/1952\n" + 
			"AINHOA,NAVARRO,31/05/1958\n" + 
			"SANDRA,MENDEZ,15/04/1953\n" + 
			"MARCOS,ROMERO,14/07/1961\n" + 
			"LIDIA,GONZALEZ,10/10/1980\n" + 
			"ESTHER,VEGA,17/03/1993\n" + 
			"JULIAN,ROMERO,02/07/1963\n" + 
			"JORDI,ESTEBAN,06/06/1968\n" + 
			"CRISTINA,RAMIREZ,24/03/1956\n" + 
			"CONSUELO,GARRIDO,12/08/1955\n" + 
			"JOSE FRANCISCO,TORRES,06/09/1968\n" + 
			"EMILIO,LORENZO,22/11/1955\n" + 
			"MARIA CARMEN,SAEZ,11/06/2000\n" + 
			"ROSARIO,GIL,02/07/1994\n" + 
			"MARIA JOSEFA,HERRERO,05/08/1963\n" + 
			"JOSEP,HIDALGO,05/10/1969\n" + 
			"PAULA,BENITEZ,06/01/1962\n" + 
			"SUSANA,RAMOS,13/12/1997\n" + 
			"ALEJANDRO,ALONSO,04/06/1969\n" + 
			"INES,PASCUAL,10/08/1973\n" + 
			"MARIA CARMEN,ESTEBAN,09/12/1995\n" + 
			"CARLOS,CASTRO,14/06/1974\n" + 
			"SANTIAGO,SANTANA,02/09/1990";

	private List<Persona> personas;

	public PersonaRepository() {
		String[] lines = data.split("\n");
		personas = Arrays.stream(lines).map(line -> {
			String[] parts = line.split(",");
			return new Persona(parts[0], parts[1],
					LocalDate.parse(parts[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		}).collect(Collectors.toList());
	}

	public List<Persona> findAll() {
		return personas;
	}
	
	public int size() {
		return personas.size();
	}
	
	public void add(Persona p) {
		personas.add(p);
	}

}
