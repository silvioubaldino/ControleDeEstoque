package com.erp.product_type.exception;

public class ProductTypeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductTypeException() {
		super("Tipo de produto não encontrado.");
	}
}
