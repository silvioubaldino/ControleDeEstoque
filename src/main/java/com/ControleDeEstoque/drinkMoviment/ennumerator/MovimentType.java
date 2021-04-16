package com.ControleDeEstoque.drinkMoviment.ennumerator;

public enum MovimentType {

	ENTRADA("Entrada"),
	SAIDA("Saída");

	private String movimentType;
	MovimentType(String movimentType) {
		this.movimentType = movimentType;
	}
	
	public String getMovimentType() {
		return movimentType;
	}
	
}
