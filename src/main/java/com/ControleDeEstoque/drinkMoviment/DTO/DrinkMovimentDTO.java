package com.ControleDeEstoque.drinkMoviment.DTO;

import java.io.Serializable;

import com.ControleDeEstoque.model.entity.drink.Drink;
import com.ControleDeEstoque.model.entity.drink_moviment.DrinkMoviment;
import com.ControleDeEstoque.model.entity.section.Section;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkMovimentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idDrink;

	private Long idSection;

	private Double volumeMov;

	private String responsible;

	public DrinkMoviment mapp(Drink drink, Section section, DrinkMovimentDTO drinkMovimentDTO) {
		return DrinkMoviment.builder()
				.drink(drink)
				.section(section)
				.movimentType(null)
				.volumeMov(drinkMovimentDTO.getVolumeMov())
				.responsible(drinkMovimentDTO.getResponsible()).build();
	}

	public DrinkMoviment mappDelete(Drink drink, Section section, DrinkMovimentDTO drinkMovimentDTO) {
		return DrinkMoviment.builder()
				.drink(drink)
				.section(section)
				.movimentType(null)
				.volumeMov(drinkMovimentDTO.getVolumeMov())
				.responsible(drinkMovimentDTO.getResponsible()).build();
	}
}
