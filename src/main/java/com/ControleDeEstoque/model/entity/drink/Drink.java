package com.ControleDeEstoque.model.entity.drink;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Drink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDrink;

	@ManyToOne
	@JoinColumn(name = "idDrinkType")
	@NotNull
	private DrinkType drinkType;

	@Column(unique = true)
	@NotNull
	private String drinkName;

	private Double drinkVolume;
}
