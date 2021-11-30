package com.ControleDeEstoque.section.controller;

import com.ControleDeEstoque.drinkType.service.DrinkTypeService;
import com.ControleDeEstoque.model.entity.section.Section;
import com.ControleDeEstoque.section.exception.SectionException;
import com.ControleDeEstoque.section.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
		if (sectionList.isEmpty()) {
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
		if (sectionList.isEmpty()) {
			throw new SectionException();
		}else {
			return sectionList;			
		}
	}

	@GetMapping("/sectionsToInsert/{idDrinkType}/{volumeMov}")
	public List<Section> findSectionsToInsert(@PathVariable Long idDrinkType, @PathVariable Double volumeMov){
		List<Section> sectionList = sectionService.findSectionsToInsert(idDrinkType, volumeMov);
		if(sectionList.isEmpty()) {
			throw new SectionException(volumeMov);
		}
		return sectionList;
	}
	
	@GetMapping("/sectionsToRemove/{idDrinkType}/{volumeMov}")
	public List<Section> findSectionsToRemove(@PathVariable Long idDrinkType, @PathVariable Double volumeMov){
		List<Section> sectionList = sectionService.findSectionsToRemove(drinkTypeService.findById(idDrinkType), volumeMov);
		if(sectionList.isEmpty()) {
			throw new SectionException(volumeMov, "remove");
		}
		return sectionList;
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
