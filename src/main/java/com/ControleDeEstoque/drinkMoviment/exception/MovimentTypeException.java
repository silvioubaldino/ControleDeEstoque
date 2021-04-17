package com.ControleDeEstoque.drinkMoviment.exception;

public class MovimentTypeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MovimentTypeException() {
		super("Movimentações são apenas 'Entrada' ou 'Saida'.");
	}

}
