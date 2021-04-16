package com.ControleDeEstoque.drink.DTO;

import java.io.Serializable;

import com.ControleDeEstoque.model.entity.drink.Drink;

import lombok.Data;

@Data
public class DrinkDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String drinkName;

	private Double drinkVolume;

	private Long idDrinkType;

	public Drink mappDrinkDTO(DrinkDTO drinkDTO) {		
		return Drink.builder().drinkName(drinkDTO.getDrinkName()).drinkVolume(drinkDTO.getDrinkVolume()).build();
	}
}
