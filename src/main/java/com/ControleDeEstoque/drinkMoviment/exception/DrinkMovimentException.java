package com.ControleDeEstoque.drinkMoviment.exception;

import com.ControleDeEstoque.drinkMoviment.ennumerator.MovimentType;

public class DrinkMovimentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrinkMovimentException() {
		super("Movimentação de bebida não encontrada.");
	}

	public DrinkMovimentException(MovimentType movimentType) {
		super("Não é possivel realizar a " + movimentType.getMovimentType().toLowerCase() + " deste tipo de bebida nessa seção.");
	}

	public DrinkMovimentException(Long idSection, Double free) {
		super("O espaço disponivel na seção " + idSection + " é: " + free + ".");
	}

}
