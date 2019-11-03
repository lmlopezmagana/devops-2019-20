package com.salesianostriana.dam.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesianostriana.dam.dto.NuevaVentaDto;
import com.salesianostriana.dam.dto.VentaDto;
import com.salesianostriana.dam.dto.converter.GetVentaDtoConverter;
import com.salesianostriana.dam.dto.converter.NuevaVentaDtoConverter;
import com.salesianostriana.dam.error.VentaErroneaException;
import com.salesianostriana.dam.error.VentaNotFoundException;
import com.salesianostriana.dam.error.VentaSinLineasDeVentaException;
import com.salesianostriana.dam.model.Venta;
import com.salesianostriana.dam.service.VentaServicio;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ventas")
@RequiredArgsConstructor
public class VentaController {
	
	private final VentaServicio ventaServicio;
	private final GetVentaDtoConverter getVentaDtoConverter;
	private final NuevaVentaDtoConverter nuevaVentaDtoConverter;
	
	@GetMapping("/")
	public List<VentaDto> listarTodos() {
		
		List<Venta> resultList = ventaServicio.findAll();
		
		if (resultList.isEmpty())
			throw new VentaNotFoundException();
		else
			return getVentaDtoConverter.convertListVentaToListVentaDto(resultList);
	}
	
	@GetMapping("/{id}")
	public Venta obtenerUna(@PathVariable Long id)  {
		return ventaServicio.findById(id)
				.orElseThrow(() -> new VentaNotFoundException(id));
	}
	
	@PostMapping("/")
	public Venta nuevaVenta(@RequestBody NuevaVentaDto nuevaVentaDto) throws VentaSinLineasDeVentaException {
		if (nuevaVentaDto.getLineaVenta().isEmpty())
			throw new VentaSinLineasDeVentaException();

		
		return ventaServicio.save(nuevaVentaDtoConverter.convertNuevaVentaDtoToVenta(nuevaVentaDto));
		
	}
	
	@PutMapping("/{id}")
	public Venta editarVenta(@PathVariable Long id, @RequestBody Venta venta)  {
		
		if (venta.getLineasDeVenta().isEmpty())
			throw new VentaErroneaException();
		
		return ventaServicio.findById(id)
				.map(v -> {
					v.setCliente(venta.getCliente());
					v.setLineasDeVenta(venta.getLineasDeVenta());
					
					return ventaServicio.save(v);
				})
				.orElseThrow(() -> new VentaNotFoundException(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarVenta(@PathVariable Long id) {
		
		Venta v = ventaServicio.findById(id).orElseThrow(() -> new VentaNotFoundException(id));
		ventaServicio.delete(v);
		
		return ResponseEntity.noContent().build();
	}

}
