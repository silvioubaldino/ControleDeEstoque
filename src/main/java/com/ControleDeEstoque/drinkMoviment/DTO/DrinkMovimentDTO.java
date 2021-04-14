package com.ControleDeEstoque.drinkMoviment.DTO;

import java.io.Serializable;

import com.ControleDeEstoque.model.entity.drink.Drink;
import com.ControleDeEstoque.model.entity.drink_moviment.DrinkMoviment;
import com.ControleDeEstoque.model.entity.section.Section;

public class DrinkMovimentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idDrink;

	private Long idSection;

	private Double volumeMov;

	private String responsible;

	
	public DrinkMovimentDTO() {
		// TODO Auto-generated constructor stub
	}

	public DrinkMovimentDTO(Long idDrink, Long idSection, Double volumeMov, String responsible) {
		super();
		this.idDrink = idDrink;
		this.idSection = idSection;
		this.volumeMov = volumeMov;
		this.responsible = responsible;
	}
	
	public DrinkMoviment mapp (Drink drink, Section section, DrinkMovimentDTO drinkMovimentDTO) {
		return new DrinkMoviment(drink, section, "", drinkMovimentDTO.getVolumeMov(), drinkMovimentDTO.getResponsible());
	}
	
	public DrinkMoviment mappDelete (Drink drink, Section section, DrinkMovimentDTO drinkMovimentDTO) {
		return new DrinkMoviment(drink, section, "", drinkMovimentDTO.getVolumeMov(), drinkMovimentDTO.getResponsible());
	}

	public Long getIdDrink() {
		return idDrink;
	}

	public void setIdDrink(Long idDrink) {
		this.idDrink = idDrink;
	}

	public Long getIdSection() {
		return idSection;
	}

	public void setIdSection(Long idSection) {
		this.idSection = idSection;
	}

	public Double getVolumeMov() {
		return volumeMov;
	}

	public void setVolumeMov(Double volumeMov) {
		this.volumeMov = volumeMov;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

}
