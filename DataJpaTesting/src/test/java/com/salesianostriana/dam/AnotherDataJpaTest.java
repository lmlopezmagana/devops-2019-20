package com.salesianostriana.dam;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class AnotherDataJpaTest {
	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Test
	public void testInsertData() {
		Persona p = new Persona();
		p.setNombre("Luis Miguel");
		p.setApellidos("López Magaña");
		p.setFechaNacimiento(LocalDate.of(1982, 9, 18));
		entityManager.persist(p);
		
		Persona result = personaRepository.findFirstByNombre("Luis Miguel");
		
		assertThat(result.getNombre()).isEqualTo("Luis Miguel");
	}

}
