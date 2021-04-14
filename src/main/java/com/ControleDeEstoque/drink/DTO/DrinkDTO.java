package com.ControleDeEstoque.drink.DTO;

import java.io.Serializable;

import com.ControleDeEstoque.model.entity.drink.Drink;

public class DrinkDTO implements Serializable {

	private String drinkName;

	private Double drinkVolume;

	private Long idDrinkType;

	public DrinkDTO() {
	}

	public DrinkDTO(String drinkName, Double drinkVolume, Long idDrinkType) {
		super();
		this.drinkName = drinkName;
		this.drinkVolume = drinkVolume;
		this.idDrinkType = idDrinkType;
	}

	public Drink mappDrinkDTO(DrinkDTO drinkDTO) {

		return new Drink(drinkDTO.getDrinkName(), drinkDTO.getDrinkVolume());
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public Double getDrinkVolume() {
		return drinkVolume;
	}

	public void setDrinkVolume(Double drinkVolume) {
		this.drinkVolume = drinkVolume;
	}

	public Long getIdDrinkType() {
		return idDrinkType;
	}

	public void setIdDrinkType(Long idDrinkType) {
		this.idDrinkType = idDrinkType;
	}

}
