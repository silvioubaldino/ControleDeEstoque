package com.ControleDeEstoque.model.entity.drink_type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class DrinkType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDrinkType;

	@NotNull
	@Column(unique = true)
	private String drinkType;
}
