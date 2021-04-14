package com.ControleDeEstoque.section.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ControleDeEstoque.drinkType.service.DrinkTypeService;
import com.ControleDeEstoque.inventory.service.InventoryService;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.ControleDeEstoque.model.entity.inventory.Inventory;
import com.ControleDeEstoque.model.entity.section.Section;
import com.ControleDeEstoque.section.DTO.SectionDTO;
import com.ControleDeEstoque.section.repository.SectionRepository;

@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepository;
	@Autowired
	InventoryService inventoryService;
	@Autowired
	DrinkTypeService drinkTypeService;
	
	public List<Section> findAll() {
		return sectionRepository.findAll();
	}
	
	public Section findById (Long idSection) {
		return sectionRepository.findById(idSection).get();
	}
	
	public Iterable<Section> findByInventory (Long idInventory){
		Inventory inventory = inventoryService.findById(idInventory);
		return sectionRepository.findSectionByInventory(inventory);
	}
	
	public Section save (SectionDTO sectionDTO) {
		Section section = sectionDTO.mappSection(sectionDTO);
		Inventory inventory = inventoryService.findById(sectionDTO.getIdInventory()) ;
		section.setInventory(inventory);
		return sectionRepository.save(section);
	}
	
	public Section updateDrinkType (Section section, DrinkType drinkType) {
		section.setDrinkType(drinkType);
		return sectionRepository.save(section);
	}
	
	public Section updateCapacity (Section section, DrinkType drinkType) {
		if(drinkType == null) {
			section.setCapacity(0);
		} else if(drinkType.getIdDrinkType() == 1) {
			section.setCapacity(500);
		} else if(drinkType.getIdDrinkType() == 2) {
			section.setCapacity(400);
		}
		return sectionRepository.save(section);
	}
	
	public Section updateBusy (Section section, Double volumeMov) {
		section.setBusy(section.getBusy() + volumeMov);
		return sectionRepository.save(section);
	}
	
	public Double getCapacity (DrinkType drinkType) {
		if(drinkType.getIdDrinkType() == 1) {
			return 500.0;
		} else if(drinkType.getIdDrinkType() == 2) {
			return 400.0;
		} else {
			return null;
		}
	}
	
	public Double getFree (Section section) {
		return section.getCapacity() - section.getBusy();
	}
	
	public Section delete (Long idSection) {
		Section section = findById(idSection);
		//TODO tratar erro
		sectionRepository.deleteById(idSection);
		return section;
	}
}
