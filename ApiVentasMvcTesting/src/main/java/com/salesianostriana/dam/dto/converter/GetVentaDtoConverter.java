package com.salesianostriana.dam.dto.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.dto.LineaVentaDto;
import com.salesianostriana.dam.dto.VentaDto;
import com.salesianostriana.dam.model.LineaVenta;
import com.salesianostriana.dam.model.Venta;

@Component
public class GetVentaDtoConverter {
	
	
	public List<VentaDto> convertListVentaToListVentaDto(List<Venta> list) {
		return list.stream()
				.map(this::convertVentaToVentaDto)
				.collect(Collectors.toList());
	}
	
	
	public VentaDto convertVentaToVentaDto(Venta v) {
		return VentaDto.builder()
				.id(v.getId())
				.nombre(v.getCliente())
				.fecha(v.getFecha())
				.total(v.getTotal())
				.lineasDeVenta(
							v.getLineasDeVenta().stream()
								.map(this::convertLineaVentaToLineaVentaDto)
								.collect(Collectors.toSet())
						)
				.build();
	}
	
	public LineaVentaDto convertLineaVentaToLineaVentaDto(LineaVenta lv) {
		return LineaVentaDto.builder()
				.producto(lv.getProducto().getNombre())
				.cantidad(lv.getCantidad())
				.precioUnitario(lv.getPrecioUnitario())
				.build();
	}
	

}
