package com.ControleDeEstoque.model.entity.drink_moviment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DrinkMoviment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMov;
	
	private int idDrink;
	
	private int idSection;
	
	private String movimentType;
	
	private Double volumeMov;
	
	private String dateMov;
	
	private String responsible;
	
}
