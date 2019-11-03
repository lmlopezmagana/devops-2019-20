package com.salesianostriana.dam.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.model.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long>{

	
}
