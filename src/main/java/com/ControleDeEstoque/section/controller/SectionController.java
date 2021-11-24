package com.ControleDeEstoque.section.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ControleDeEstoque.drinkType.service.DrinkTypeService;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.ControleDeEstoque.model.entity.section.Section;
import com.ControleDeEstoque.section.exception.SectionException;
import com.ControleDeEstoque.section.service.SectionService;

@RestController
@RequestMapping("/section")
public class SectionController {

	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private DrinkTypeService drinkTypeService;
	
	@GetMapping
	public List<Section> findAll() {
		List<Section> sectionList = sectionService.findAll();
		if (sectionList.size() == 0) {
			throw new SectionException();
		}else {
			return sectionList;			
		}
	}
	
	@GetMapping("/{idSection}")
	public Section findById(@PathVariable Long idSection){	
		return sectionService.findById(idSection);
	}

	@GetMapping("/drinkType/{idDrinkType}")
	public List<Section> findSectionByDrinkTypeIdDrinkType (@PathVariable Long idDrinkType){
		List<Section> sectionList = sectionService.findSectionByDrinkTypeIdDrinkType(idDrinkType);
		if (sectionList.isEmpty()){
			throw new SectionException();
		} else {
			return sectionList;
		}
	}
	
	@GetMapping("/inventory/{idInventory}")
	public List<Section> findByInventory(@PathVariable Long idInventory){		
		List<Section> sectionList = sectionService.findByInventory(idInventory);
		if (sectionList.size() == 0) {
			throw new SectionException();
		}else {
			return sectionList;			
		}
	}

	@GetMapping("/sectionsToInsert/{idDrinkType}/{volumeMov}")
	public List<Section> findSectionsToInsert(@PathVariable Long idDrinkType, @PathVariable Double volumeMov){
		List<Section> sectiontList = sectionService.findSectionsToInsert(drinkTypeService.findById(idDrinkType), volumeMov);
		if(sectiontList.size() == 0) {
			throw new SectionException(volumeMov);
		}
		return sectiontList;
	}
	
	@GetMapping("/sectionsToRemove/{idDrinkType}/{volumeMov}")
	public List<Section> findSectionsToRemove(@PathVariable Long idDrinkType, @PathVariable Double volumeMov){
		List<Section> sectiontList = sectionService.findSectionsToRemove(drinkTypeService.findById(idDrinkType), volumeMov);
		if(sectiontList.size() == 0) {
			throw new SectionException(volumeMov, "remove");
		}
		return sectiontList;
	}
	
	@PostMapping("/{idInventory}")
	public Section save (@PathVariable Long idInventory){
		return sectionService.save(idInventory);
	}
	
	@DeleteMapping("/{idSection}")
	public Section delete (@PathVariable Long idSection) {
		return sectionService.delete(idSection);
	}
}
