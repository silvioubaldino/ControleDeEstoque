package com.ControleDeEstoque.drink.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ControleDeEstoque.drink.DTO.DrinkDTO;
import com.ControleDeEstoque.drink.repository.DrinkRepository;
import com.ControleDeEstoque.drinkType.service.DrinkTypeService;
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
	
	public Drink findById(Long idDrink) {
		return drinkRepository.findById(idDrink).get();
	}
	
	public Iterable<Drink> findByName (String name){
		return drinkRepository.findBydrinkNameIgnoreCase(name);
	}
	
	public List<Drink> findByDrinkType (Long idDrinkType){
		DrinkType drinkType = drinkTypeService.findById(idDrinkType);
		return drinkRepository.findDrinkByDrinkType(drinkType);
	}
	
	public Drink save (DrinkDTO drinkDTO) {
		Drink drink = drinkDTO.mappDrinkDTO(drinkDTO);
		DrinkType drinkType = drinkTypeService.findById(drinkDTO.getIdDrinkType());
		drink.setDrinkType(drinkType);
		return drinkRepository.save(drink);		
	}
	
	public Drink delete (Long idDrink) {
		Drink drink = findById(idDrink);
		//TODO tratar erro
		drinkRepository.deleteById(idDrink);
		return drink;
	}
}
