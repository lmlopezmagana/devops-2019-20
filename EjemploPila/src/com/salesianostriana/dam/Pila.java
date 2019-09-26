package com.salesianostriana.dam;

import java.util.Stack;

public class Pila {
	
	Stack<Integer> stack = new Stack<>();
	
	public void push(Integer e) {
		if (esPrimo(e))
			stack.push(e);		
	}
	
	public Integer pop() {
		if (stack.isEmpty())
			return null;
		else
			return stack.pop();
	}
	
	public Integer top() {
		if (stack.isEmpty())
			return null;
		else
			return stack.peek();
	}
	
	public int size() {
		return stack.size();
	}

	private boolean esPrimo(Integer e) {
		int tope = (int) Math.sqrt(e);
		boolean esPrimo = true;
		int divisor = 2;
		while(divisor <= tope && esPrimo) {
			if (e % divisor == 0)
				esPrimo = false;
			else
				divisor++;
		}
		return esPrimo;
	}
	

}
