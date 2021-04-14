package com.ControleDeEstoque.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ControleDeEstoque.inventory.Repository.InventoryRepository;
import com.ControleDeEstoque.model.entity.inventory.Inventory;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;
	
	public Inventory findById(Long idInventory) {
		return inventoryRepository.findById(idInventory).get();
	}
}
