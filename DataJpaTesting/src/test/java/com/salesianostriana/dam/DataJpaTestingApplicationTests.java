package com.salesianostriana.dam;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@ActiveProfiles("test")
public class DataJpaTestingApplicationTests {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Test
	@Sql("sql/insertTestData.sql")
	public void testNombreContieneDevuelveValor() {
		List<Persona> result = personaRepository.nombreContiene("Jesús");
		
		assertThat(result.get(0).getNombre()).contains("Jesús");
	}
	

	@Test
	@Sql("sql/insertTestData.sql")
	public void test_nombreContieneNoDevuelveValor() {
		List<Persona> result = personaRepository.nombreContiene("María");
		
		assertThat(result).isEmpty();
	}


	@Test
	@Sql("sql/insertTestData.sql")
	public void testMayorDe40DevuelveValor() {
		List<Persona> result = personaRepository.mayoresDeCuarenta();
		
		assertThat(result.get(0).getFechaNacimiento()).isBefore(LocalDate.now().minus(40, ChronoUnit.YEARS));
	}

	
}
