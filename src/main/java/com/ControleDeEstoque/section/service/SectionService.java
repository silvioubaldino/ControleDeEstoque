package com.ControleDeEstoque.section.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ControleDeEstoque.inventory.service.InventoryService;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.ControleDeEstoque.model.entity.inventory.Inventory;
import com.ControleDeEstoque.model.entity.section.Section;
import com.ControleDeEstoque.section.exception.SectionException;
import com.ControleDeEstoque.section.repository.SectionRepository;

@Service
public class SectionService {

	@Autowired
	private SectionRepository sectionRepository;
	@Autowired
	private InventoryService inventoryService;

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

	public List<Section> findSectionsToInsert(DrinkType drinkType, Double volumeMov) {
		List<Section> allSections = findAll();
		List<Section> sectionsToInsert = new ArrayList<>();
		for (Section section : allSections) {
			DrinkType eachDrinkType = section.getDrinkType();
			if (eachDrinkType == null) {
				if (volumeMov <= getCapacity(drinkType)) {
					sectionsToInsert.add(section);
				}
			} else if (eachDrinkType == drinkType) {
				if (volumeMov <= getFree(section)) {
					sectionsToInsert.add(section);
				}
			}
		}
		return sectionsToInsert;
	}

	public List<Section> findSectionsToRemove(DrinkType drinkType, Double volumeMov) {
		List<Section> allSections = findAll();
		List<Section> sectionsToRemove = new ArrayList<>();
		for (Section section : allSections) {
			DrinkType eachDrinkType = section.getDrinkType();
			if (eachDrinkType == drinkType) {
				if (volumeMov <= section.getBusy()) {
					sectionsToRemove.add(section);
				}
			}
		}
		return sectionsToRemove;
	}

	public Section save(Long idInventory) {
		Inventory inventory = inventoryService.findById(idInventory);
		return sectionRepository.save(Section.builder().busy(0.0).capacity(0.0).inventory(inventory).build());
	}

	public Section updateDrinkType(Section section, DrinkType drinkType) {
		section.setDrinkType(drinkType);
		return sectionRepository.save(section);
	}

	public Section updateCapacity(Section section, DrinkType drinkType) {
		if (drinkType == null) {
			section.setCapacity(0.0);
		} else if (drinkType.getIdDrinkType() == 1) {
			section.setCapacity(500.0);
		} else if (drinkType.getIdDrinkType() == 2) {
			section.setCapacity(400.0);
		}
		return sectionRepository.save(section);
	}

	public Section updateBusy(Section section, Double volumeMov) {
		section.setBusy(section.getBusy() + volumeMov);
		return sectionRepository.save(section);
	}

	public Double getCapacity(DrinkType drinkType) {
		if (drinkType.getIdDrinkType() == 1) {
			return 500.0;
		} else if (drinkType.getIdDrinkType() == 2) {
			return 400.0;
		} else {
			return null;
		}
	}

	public Double getFree(Section section) {
		return section.getCapacity() - section.getBusy();
	}

	public Section delete(Long idSection) {
		Section section = findById(idSection);
		sectionRepository.deleteById(idSection);
		return section;
	}
}
