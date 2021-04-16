package com.ControleDeEstoque.drink.exception;

public class DrinkException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrinkException() {
		super("Bebida não encontrada.");
	}
}
