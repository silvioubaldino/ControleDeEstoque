package com.ControleDeEstoque.inventory.exception;

public class InventoryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InventoryException() {
		super("Estoque não encontrado.");
	}
}
