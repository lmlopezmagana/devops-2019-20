package com.salesianostriana.dam;

import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.salesianostriana.dam.model.LineaVenta;
import com.salesianostriana.dam.model.Producto;
import com.salesianostriana.dam.model.Venta;
import com.salesianostriana.dam.service.ProductoServicio;
import com.salesianostriana.dam.service.VentaServicio;

@SpringBootApplication
public class ApiVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiVentasApplication.class, args);
	}
	
	@Profile("dev")
	@Bean
	public CommandLineRunner initData(ProductoServicio productoServicio, VentaServicio ventaServicio) {
		return args -> {
			String[] nombres = "Luis Leon,Jose Manuel Diez,Andrea Esteban,Victor Muñoz,Maria Soledad Medina,Patricia Soler,Jose Carlos Roman,Fatima Blanco,Joan Dominguez,Miriam Prieto".split(",");
			
			
			Random r = new Random(System.currentTimeMillis());
			
			// Para cada cliente, generamos de 1 a 3 ventas
			for (String nombre : nombres) {
				int cantidadVentas = r.nextInt(3)+1;
				for(int i = 0; i < cantidadVentas; i++) {
					Venta v = new Venta();
					v.setCliente(nombre);
					// Para cada venta, añadimos un número aleatorio de 3 a 8 productos.
					// Para cada producto, la cantidad también es aleatoria entre 1 y 5 unidades.
					int cantidadProductos = r.nextInt(5) + 3;
					List<Producto> productosAleatorios = productoServicio.getNProductosAleatorios(cantidadProductos);
					for (Producto p : productosAleatorios) {
						int cantidadEnLineaDeVenta = r.nextInt(5)+1;
						LineaVenta lv = LineaVenta.builder()
											.cantidad(cantidadEnLineaDeVenta)
											.producto(p)
											.venta(v)
											.precioUnitario(p.getPrecio())
											.build();
						v.addLineaVenta(lv);
					}
					ventaServicio.save(v);
				}
			}
			
			
			
		};
		
		
		
		
	}

}
