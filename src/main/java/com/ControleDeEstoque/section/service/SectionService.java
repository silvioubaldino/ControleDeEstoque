package com.ControleDeEstoque.section.service;

import com.ControleDeEstoque.drinkType.exception.DrinkTypeException;
import com.ControleDeEstoque.drinkType.service.DrinkTypeService;
import com.ControleDeEstoque.inventory.service.InventoryService;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.ControleDeEstoque.model.entity.inventory.Inventory;
import com.ControleDeEstoque.model.entity.section.Section;
import com.ControleDeEstoque.section.exception.SectionException;
import com.ControleDeEstoque.section.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService {

	@Autowired
	private SectionRepository sectionRepository;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private DrinkTypeService drinkTypeService;

	public List<Section> findAll() {
		return sectionRepository.findAll();
	}

	public Section findById(Long idSection) {
		return sectionRepository.findById(idSection).orElseThrow(SectionException::new);
	}

	public List<Section> findByInventory(Long idInventory) {
		Inventory inventory = inventoryService.findById(idInventory);
		return sectionRepository.findSectionByInventory(inventory);
	}

	public List<Section> findSectionByDrinkTypeIdDrinkType (Long idDrinkType){
		return sectionRepository.findSectionByDrinkTypeIdDrinkType(idDrinkType);
	}

	public List<Section> findSectionsToInsert(Long idDrinkType, Double volumeMov) {
		DrinkType drinkType = drinkTypeService.findById(idDrinkType);
		List<Section> allSections = findAll();
		List<Section> sectionsToInsert = new ArrayList<>();
		for (Section section : allSections) {
			DrinkType eachDrinkType = section.getDrinkType() != null ? section.getDrinkType() : drinkType;
			if ((drinkType == eachDrinkType || eachDrinkType == null) && volumeMov <= calcFree(section, eachDrinkType)){
				sectionsToInsert.add(section);
			}
		}
		return sectionsToInsert;
	}

	public List<Section> findSectionsToRemove(DrinkType drinkType, Double volumeMov) {
		List<Section> allSections = findAll();
		List<Section> sectionsToRemove = new ArrayList<>();
		for (Section section : allSections) {
			DrinkType eachDrinkType = section.getDrinkType();
			if (eachDrinkType == drinkType && volumeMov <= section.getBusy()) {
				sectionsToRemove.add(section);
			}
		}
		return sectionsToRemove;
	}

	public Section save(Long idInventory) {
		Inventory inventory = inventoryService.findById(idInventory);
		return sectionRepository.save(Section.builder().busy(0.0).capacity(0.0).inventory(inventory).build());
	}

	public Section updateDrinkType(Section section, DrinkType drinkType) {
		if (findById(section.getIdSection()).getDrinkType() != drinkType){
			section.setDrinkType(drinkType);
		}
		return section;
	}

	public Section updateCapacity(Section section, DrinkType drinkType) {
		if (drinkType == null) {
			section.setCapacity(0.0);
		} else if (drinkType.getIdDrinkType() == 1) {
			section.setCapacity(500.0);
		} else if (drinkType.getIdDrinkType() == 2) {
			section.setCapacity(400.0);
		}
		return section;
	}

	public Section updateBusy(Section section, Double volumeMov) {
		section.setBusy(section.getBusy() + volumeMov);
		return section;
	}

	public Double calcCapacity(DrinkType drinkType) {
		if (drinkType.getIdDrinkType() == 1) {
			return 500.0;
		} else if (drinkType.getIdDrinkType() == 2) {
			return 400.0;
		}
		throw new DrinkTypeException();
	}

	public Double calcFree(Section section, DrinkType drinkType) {
		return section.getDrinkType() == null ? calcCapacity(drinkType) : section.getCapacity() - section.getBusy();
	}

	public Section delete(Long idSection) {
		Section section = findById(idSection);
		sectionRepository.deleteById(idSection);
		return section;
	}
}
