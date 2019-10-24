package com.salesianostriana.dam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataJpaTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaTestingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner main(PersonaRepository repo) {
		return args -> {
			System.out.println("MAYORES DE CUARENTA");
			repo.mayoresDeCuarenta().forEach(System.out::println);
			
			System.out.println("QUE CONTIENEN MIGUEL");
			repo.nombreContiene("Miguel").forEach(System.out::println);
			
		};
	}

}
