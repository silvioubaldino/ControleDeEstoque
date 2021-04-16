package com.ControleDeEstoque.drinkType.exception;

public class DrinkTypeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrinkTypeException() {
		super("Tipo de bebida não encontrado.");
	}
}
