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

	private Double busy;

	public Section() {
		// TODO Auto-generated constructor stub
	}

	public Section(Inventory inventory, DrinkType drinkType, int capacity, Double busy) {
		super();
		this.inventory = inventory;
		this.drinkType = drinkType;
		this.capacity = capacity;
		this.busy = busy;
	}

	public Section(int capacity, Double busy) {
		super();
		this.capacity = capacity;
		this.busy = busy;
	}

	public Long getIdSection() {
		return idSection;
	}

	public void setIdSection(Long idSection) {
		this.idSection = idSection;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public DrinkType getDrinkType() {
		return drinkType;
	}

	public void setDrinkType(DrinkType drinkType) {
		this.drinkType = drinkType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Double getBusy() {
		return busy;
	}

	public void setBusy(Double busy) {
		this.busy = busy;
	}
	
	

}
