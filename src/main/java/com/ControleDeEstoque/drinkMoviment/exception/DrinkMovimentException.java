package com.ControleDeEstoque.drinkMoviment.exception;

import com.ControleDeEstoque.drinkMoviment.ennumerator.MovimentType;
import com.ControleDeEstoque.model.entity.drink.Drink;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;

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

	public DrinkMovimentException(Drink drink, DrinkType drinkType) {
		super(drink.getDrinkName() + " não é do tipo " + drinkType.getDrinkType().toLowerCase());
	}

	public DrinkMovimentException(Long idSection, Double free) {
		super("O espaço disponivel na seção " + idSection + " é: " + free + ".");
	}
	
	public DrinkMovimentException(Long idSection, Double free, String isRemove) {
		super("A quantidade disponivel para retirada na seção " + idSection + " é: " + free + ".");
	}

}
