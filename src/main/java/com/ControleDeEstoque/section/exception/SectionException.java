package com.ControleDeEstoque.section.exception;

public class SectionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SectionException() {
		super("Seção não encontrada.");
	}
	
	public SectionException(Double volumeMov, String remove) {
		super("Nenhuma seção tem " + volumeMov + " para remover.");
	}
	
	public SectionException(Double volumeMov) {
		super("Nenhuma seção tem espaço para " + volumeMov);
	}
}
