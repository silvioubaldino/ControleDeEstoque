package com.ControleDeEstoque.drinkType.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ControleDeEstoque.drinkType.exception.DrinkTypeException;
import com.ControleDeEstoque.drinkType.service.DrinkTypeService;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;

@RestController
@RequestMapping("/drinkType")
public class DrinkTypeController {

	@Autowired
	DrinkTypeService drinkTypeService;
	
	@GetMapping
	public List<DrinkType> findAll() {	    
		List<DrinkType> drinkTypeList = drinkTypeService.findAll();
		if (drinkTypeList.size() == 0) {
			throw new DrinkTypeException();
		} else {
			return drinkTypeList;
		}
	}
	
	@GetMapping("/{idDrinkType}")
	public DrinkType findById(@PathVariable Long idDrinkType){
		return drinkTypeService.findById(idDrinkType);
	}
	
	@GetMapping("/name/{drinkType}")
	public List<DrinkType> findByName(@PathVariable String drinkType){
		List<DrinkType> drinkTypeList = drinkTypeService.findByName(drinkType);
		if (drinkTypeList.size() == 0) {
			throw new DrinkTypeException();
		} else {
			return drinkTypeList;
		}
	}
	
	@PostMapping
	public DrinkType save (@RequestBody DrinkType drinkType){
		return drinkTypeService.save(drinkType);
	}
	
	@DeleteMapping("/{idDrinkType}")
	public DrinkType delete (@PathVariable Long idDrinkType) {
		return drinkTypeService.delete(idDrinkType);
	}
}
