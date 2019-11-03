package com.salesianostriana.dam.service;

import java.util.List;
import java.util.Random;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Producto;
import com.salesianostriana.dam.repos.ProductoRepositorio;
import com.salesianostriana.dam.service.base.BaseService;

@Service
public class ProductoServicio extends BaseService<Producto, Long, ProductoRepositorio> {
	
	public List<Producto> getNProductosAleatorios(int n) {
		
		int total = (int) this.repositorio.count();
		
		// Para escoger el nº de página, dividimos el nº de productos aleatorios
		// solicitados entre el total.
		// Si n > total, devolvemos todos los productos
		// En otro caso, escogemos un nº aleatorio de página entre 0 y (total/n)
		if (n >= total) {
			return findAll();
		} else {
			int numPaginas = total / n;
			int randomPage = new Random().nextInt(numPaginas);
			Page<Producto> pageResult = this.repositorio.findAll(PageRequest.of(randomPage, n));
			return pageResult.getContent();
		}
		
	}


}
