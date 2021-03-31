package com.ControleDeEstoque.model.entity.drink;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ControleDeEstoque.model.entity.drink_type.DrinkType;

@Entity
public class Drink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDrink;

	@ManyToOne
	@JoinColumn(name = "idDrinkType")
	private DrinkType drinkType;

	private String drinkName;

	private Double drinkVolume;

	public Drink() {
		// TODO Auto-generated constructor stub
	}

	public Drink(DrinkType drinkType, String drinkName, Double drinkVolume) {
		super();
		this.drinkType = drinkType;
		this.drinkName = drinkName;
		this.drinkVolume = drinkVolume;
	}

	public Long getIdDrink() {
		return idDrink;
	}

	public void setIdDrink(Long idDrink) {
		this.idDrink = idDrink;
	}

	public DrinkType getDrinkType() {
		return drinkType;
	}

	public void setDrinkType(DrinkType drinkType) {
		this.drinkType = drinkType;
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

}
