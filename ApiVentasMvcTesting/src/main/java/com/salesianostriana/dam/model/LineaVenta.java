package com.salesianostriana.dam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Builder
@Data @NoArgsConstructor @AllArgsConstructor
public class LineaVenta {

	@Id @GeneratedValue
	private Long id;
	
	private int cantidad;
	@Column(name="precio_unitario")
	private float precioUnitario;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "venta_id")
	private Venta venta;
	
	public float getSubTotal() {
		return precioUnitario * cantidad;
	}
	
}
