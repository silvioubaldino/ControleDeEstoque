package com.ControleDeEstoque.model.entity.drink;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ControleDeEstoque.model.entity.drink_type.DrinkType;

@Entity
public class Drink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDrink;
	
	private int drinkType;
	
	private String drinkName;
	
	private Double drinkVolume;
}
