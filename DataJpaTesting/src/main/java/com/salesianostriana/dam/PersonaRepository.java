package com.salesianostriana.dam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
	
	@Query(value = "select * from Persona where DATEDIFF(YEAR, FECHA_NACIMIENTO, CURRENT_DATE) >= 40", nativeQuery = true)
	public List<Persona> mayoresDeCuarenta();
	
	@Query("select p from Persona p where nombre like concat('%',:nombre, '%')")
	public List<Persona> nombreContiene(@Param("nombre") String nombre);
	
	public Persona findFirstByNombre(String nombre);

}
