package com.salesianostriana.dam.dto.converter;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.dto.NuevaLineaVentaDto;
import com.salesianostriana.dam.dto.NuevaVentaDto;
import com.salesianostriana.dam.error.ProductoNotFoundException;
import com.salesianostriana.dam.model.LineaVenta;
import com.salesianostriana.dam.model.Producto;
import com.salesianostriana.dam.model.Venta;
import com.salesianostriana.dam.service.ProductoServicio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NuevaVentaDtoConverter {
	
	private final ProductoServicio productoServicio;
	
	public Venta convertNuevaVentaDtoToVenta(NuevaVentaDto nuevaVentaDto) {
		return Venta.builder()
				.cliente(nuevaVentaDto.getNombre())
				.lineasDeVenta(nuevaVentaDto
									.getLineaVenta()
									.stream()
									.map(this::convertNuevaLineaVentaDtotoLineaVenta)
									.collect(Collectors.toSet()))
				.build();
	}
	
	public LineaVenta convertNuevaLineaVentaDtotoLineaVenta(NuevaLineaVentaDto nuevaLineaVenta) {
		Producto p = productoServicio
						.findById(nuevaLineaVenta.getIdProducto())
							.orElseThrow(() -> new ProductoNotFoundException(nuevaLineaVenta.getIdProducto()));
		return LineaVenta.builder()
				.cantidad(nuevaLineaVenta.getCantidad())
				.producto(p)
				.precioUnitario(p.getPrecio())
				.build();
	}

}
