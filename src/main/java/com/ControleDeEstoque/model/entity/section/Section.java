package com.ControleDeEstoque.model.entity.section;

import javax.persistence.*;

import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.ControleDeEstoque.model.entity.inventory.Inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "section")
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSection;

	@ManyToOne
	@JoinColumn(name = "idInventory")
	private Inventory inventory;

	@ManyToOne
	@JoinColumn(name = "idDrinkType")
	private DrinkType drinkType;

	private Double capacity;

	private Double busy;
}
