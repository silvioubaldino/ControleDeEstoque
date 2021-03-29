package com.ControleDeEstoque.model.entity.inventory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ControleDeEstoque.model.entity.section.Section;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInventory;
	
	private String typeInventory;
	
	@OneToMany(mappedBy = "inventory")
	private List<Section> section = new ArrayList<>();
	
	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public Inventory(String typeInventory) {
		super();
		this.typeInventory = typeInventory;
	}
	
	
}
