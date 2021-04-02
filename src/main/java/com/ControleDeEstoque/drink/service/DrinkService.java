package com.ControleDeEstoque.drink.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ControleDeEstoque.drink.repository.DrinkRepository;
import com.ControleDeEstoque.drinkType.service.DrinkTypeService;
import com.ControleDeEstoque.model.DTO.DrinkDTO;
import com.ControleDeEstoque.model.entity.drink.Drink;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;

@Service
public class DrinkService {

	@Autowired
	DrinkRepository drinkRepository;
	
	@Autowired
	DrinkTypeService drinkTypeService;
	
	public Iterable<Drink> findAll() {
		return drinkRepository.findAll();
	}
	
	public Optional<Drink> findById(Long idDrink) {
		return drinkRepository.findById(idDrink);
	}
	
	public Iterable<Drink> findByName (String name){
		return drinkRepository.findBydrinkNameIgnoreCase(name);
	}
	
	public Iterable<Drink> findByDrinkType (Long idDrinkType){
		DrinkType drinkType = drinkTypeService.findDrinkTypeById(idDrinkType);
		return drinkRepository.findDrinkByDrinkType(drinkType);
	}
	
	public Drink saveDrink (DrinkDTO drinkDTO) {
		Drink drink = drinkDTO.mappDrinkDTO(drinkDTO);
		DrinkType drinkType = drinkTypeService.findDrinkTypeById(drinkDTO.getIdDrinkType());
		drink.setDrinkType(drinkType);
		return drinkRepository.save(drink);		
	}
	
	public void deleteDrink (Long id) {
		drinkRepository.deleteById(id);
	}
}
