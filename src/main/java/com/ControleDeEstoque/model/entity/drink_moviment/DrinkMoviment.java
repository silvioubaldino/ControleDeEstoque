package com.ControleDeEstoque.model.entity.drink_moviment;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.ControleDeEstoque.model.entity.drink.Drink;
import com.ControleDeEstoque.model.entity.section.Section;

@Entity
public class DrinkMoviment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMov;

	@ManyToOne
	@JoinColumn(name = "idDrink")
	private Drink drink;

	@ManyToOne
	@JoinColumn(name = "idSection")
	private Section section;

	private String movimentType;

	private Double volumeMov;

	@CreationTimestamp
	private LocalDateTime dateMov;

	private String responsible;

	public DrinkMoviment() {
		// TODO Auto-generated constructor stub
	}

	public DrinkMoviment(Drink drink, Section section, String movimentType, Double volumeMov, String responsible) {
		super();
		this.drink = drink;
		this.section = section;
		this.movimentType = movimentType;
		this.volumeMov = volumeMov;
		this.responsible = responsible;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String getMovimentType() {
		return movimentType;
	}

	public void setMovimentType(String movimentType) {
		this.movimentType = movimentType;
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
