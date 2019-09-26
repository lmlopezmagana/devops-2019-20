package com.salesianostriana.dam.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.salesianostriana.dam.Pila;

public class PilaTest {

	Pila pila;
	
	@Before
	public void setUp() {
		pila = new Pila();
		pila.push(2);
		pila.push(3);
		pila.push(5);
		pila.push(7);
	}

	@Test
	public final void testPushNumeroPrimo() {
		pila.push(11);
		
		assertThat(pila.size(), is(5));
	}
	
	@Test
	public final void testPushNumeroNoPrimo() {
		pila.push(12);
		
		assertThat(pila.size(), is(4));
	}

	@Test
	public final void testPop() {
		Integer valor = pila.pop();
		
		assertThat(valor, is(7));
		assertThat(pila.size(), is(3));
	}
	
	@Test
	public final void testPopEmptyStack() {
		
		Pila otraPila = new Pila();
		
		Integer valor = otraPila.pop();

		assertNull(valor);
		assertThat(otraPila.size(), is(0));
	}
	

	@Test
	public final void testTop() {
		Integer valor = pila.top();
		
		assertThat(valor, is(7));
		assertThat(pila.size(), is(4));
	}

	
	@Test
	public final void testSize() {
		assertThat(pila.size(), is(4));
	}

}
