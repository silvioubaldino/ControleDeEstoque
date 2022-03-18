package com.erp.inventory.service;

import com.erp.inventory.DTO.InventoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.inventory.Repository.InventoryRepository;
import com.erp.inventory.exception.InventoryException;
import com.erp.inventory.entity.Inventory;

import java.util.List;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	public List<Inventory> findAll(){
		return inventoryRepository.findAll();
	}
	
	public Inventory findById(Long idInventory) {
		return inventoryRepository.findById(idInventory).orElseThrow(InventoryException::new);
	}

	public Inventory save(InventoryDTO inventoryDTO) {
		Inventory inventory = Inventory.builder()
				.name(inventoryDTO.getName())
				.build();
		return inventoryRepository.save(inventory);
	}
}
