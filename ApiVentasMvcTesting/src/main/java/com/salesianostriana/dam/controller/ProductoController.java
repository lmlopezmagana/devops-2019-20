package com.salesianostriana.dam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesianostriana.dam.error.ProductoNotFoundException;
import com.salesianostriana.dam.model.Producto;
import com.salesianostriana.dam.service.ProductoServicio;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/producto/")
@RequiredArgsConstructor
public class ProductoController {
	
	private final ProductoServicio productoServicio;
	
	@GetMapping("/")
	public List<Producto> index() {
		
		List<Producto> resultList = productoServicio.findAll();
		
		if (resultList.isEmpty())
			throw new ProductoNotFoundException();
		else
			return resultList;
		
		
	}
	
	
	@GetMapping("/{id}")
	public Producto unProducto(@PathVariable Long id) {
		return productoServicio.findById(id)
				.orElseThrow(()-> new ProductoNotFoundException(id));
	}

	@PostMapping("/")
	//public Producto nuevoProducto(@RequestBody Producto producto) {
	public ResponseEntity<Producto> nuevoProducto(@RequestBody Producto producto) {
		//return productoServicio.save(producto);
		Producto result = productoServicio.save(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping("/{id}")
	public Producto editarProducto(@PathVariable Long id, @RequestBody Producto producto) {
		return productoServicio.findById(id)
				.map(p -> {
					p.setNombre(producto.getNombre());
					p.setPrecio(producto.getPrecio());
					return productoServicio.save(p);
				}).orElseThrow(()-> new ProductoNotFoundException(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarProducto(@PathVariable Long id) {
	
		Producto p = productoServicio.findById(id).orElseThrow(()-> new ProductoNotFoundException());
		productoServicio.delete(p);
		
		return ResponseEntity.noContent().build();
		
		
	}
	

}
