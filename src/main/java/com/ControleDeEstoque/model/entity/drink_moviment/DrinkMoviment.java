package com.ControleDeEstoque.model.entity.drink_moviment;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.ControleDeEstoque.drinkMoviment.ennumerator.MovimentType;
import com.ControleDeEstoque.model.entity.drink.Drink;
import com.ControleDeEstoque.model.entity.section.Section;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
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

	@Enumerated
	private MovimentType movimentType;

	private Double volumeMov;

	@CreationTimestamp
	private LocalDateTime dateMov;

	private String responsible;
}
