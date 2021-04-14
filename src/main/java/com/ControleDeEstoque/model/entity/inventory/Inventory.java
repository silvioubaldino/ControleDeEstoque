package com.ControleDeEstoque.model.entity.inventory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInventory;

	private String typeInventory;

	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public Inventory(String typeInventory) {
		super();
		this.typeInventory = typeInventory;
	}

	public String getTypeInventory() {
		return typeInventory;
	}

	public void setTypeInventory(String typeInventory) {
		this.typeInventory = typeInventory;
	}

	public Long getIdInventory() {
		return idInventory;
	}

}
