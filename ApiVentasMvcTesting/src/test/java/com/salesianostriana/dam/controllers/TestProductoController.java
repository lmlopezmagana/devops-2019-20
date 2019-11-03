package com.salesianostriana.dam.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.salesianostriana.dam.controller.ProductoController;
import com.salesianostriana.dam.model.Producto;
import com.salesianostriana.dam.service.ProductoServicio;

@WebMvcTest(controllers = ProductoController.class)
public class TestProductoController {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private ProductoServicio productoServicio;

	@Test
	public void whenGetWithData_thenReturns200() throws Exception {

		Producto p = Producto.builder().id(1L).nombre("Producto de prueba").precio(10).build();
		List<Producto> lista = new ArrayList<>();
		lista.add(p);

		when(productoServicio.findAll()).thenReturn(lista);

		mockMvc.perform(get("/producto/")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));

	}

	@Test
	public void whenGetWithoutData_thenReturns404() throws Exception {
		when(productoServicio.findAll()).thenReturn(Collections.emptyList());

		mockMvc.perform(get("/producto/")).andExpect(status().isNotFound());

	}

	@Test
	public void whenGetById_thenReturns200() throws Exception {

		Producto p = Producto.builder().id(1L).nombre("Producto de prueba").precio(10).build();
		when(productoServicio.findById(1l)).thenReturn(Optional.of(p));

		mockMvc.perform(get("/producto/1")).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(1l))
				.andExpect(jsonPath("nombre").value("Producto de prueba")).andExpect(jsonPath("precio").value(10));

	}

	@Test
	public void whenGetById_thenReturns404() throws Exception {

		when(productoServicio.findById(2l)).thenReturn(Optional.empty());

		mockMvc.perform(get("/producto/2")).andExpect(status().isNotFound());

	}

	@Test
	public void whenPost_thenReturns201() throws Exception {

		Producto preSaved = Producto.builder().nombre("Producto de prueba").precio(10).build();
		Producto postSaved = Producto.builder().id(1L).nombre("Producto de prueba").precio(10).build();

		when(productoServicio.save(preSaved)).thenReturn(postSaved);

		MvcResult result = mockMvc
				.perform(post("/producto/").contentType("application/json")
						.content(objectMapper.writeValueAsString(preSaved)))
				.andExpect(status().isCreated()).andReturn();

		String resultAsString = result.getResponse().getContentAsString();
		assertThat(objectMapper.writeValueAsString(postSaved)).isEqualToIgnoringCase(resultAsString);

	}

	/**
	 * Si tuviéramos validación, o alguna pequeña regla de negocio faltaría añadir
	 * un test que comprueba que si posteamos datos erróneos, se produce un error
	 * 400.
	 * @throws Exception 
	 * @throws JsonProcessingException 
	 */

	@Test
	public void whenPut_thenReturn200() throws Exception {

		Producto oldProducto = Producto.builder().id(1L).nombre("Producto de prueba").precio(10).build();
		Producto newProducto = Producto.builder().id(1L).nombre("Nuevo nombre").precio(11).build();

		when(productoServicio.findById(1l)).thenReturn(Optional.of(oldProducto));
		when(productoServicio.save(newProducto)).thenReturn(newProducto);

		MvcResult result = mockMvc
				.perform(put("/producto/{id}", 1l).contentType("application/json")
						.content(objectMapper.writeValueAsString(newProducto)))
				.andExpect(status().isOk()).andReturn();

		String resultAsString = result.getResponse().getContentAsString();
		assertThat(objectMapper.writeValueAsString(newProducto)).isEqualToIgnoringCase(resultAsString);

	}

}
