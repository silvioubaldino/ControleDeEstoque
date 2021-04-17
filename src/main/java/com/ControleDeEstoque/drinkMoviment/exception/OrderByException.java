package com.ControleDeEstoque.drinkMoviment.exception;

public class OrderByException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderByException() {
		super("O parametro de ordenação deve ser informado em '/{drinkType}/{params}' "
				+ "podendo ser: 'idMov', 'drink', 'section', 'movimentType', 'volumeMov', 'dateMov'.");
	}
}
