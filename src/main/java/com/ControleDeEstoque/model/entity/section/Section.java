package com.ControleDeEstoque.model.entity.section;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.ControleDeEstoque.model.entity.inventory.Inventory;

@Entity
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

	private int capacity;

	private int busy;

	public Section() {
		// TODO Auto-generated constructor stub
	}

	public Section(Inventory inventory, DrinkType drinkType, int capacity, int busy) {
		super();
		this.inventory = inventory;
		this.drinkType = drinkType;
		this.capacity = capacity;
		this.busy = busy;
	}

}
