package com.ControleDeEstoque.drinkType.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ControleDeEstoque.drinkType.repository.DrinkTypeRepository;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;

@Service
public class DrinkTypeService {

	@Autowired
	DrinkTypeRepository drinkTypeRepository;
	
	public Iterable<DrinkType> findAll(){
		return drinkTypeRepository.findAll();
	}
	
	public DrinkType findById(Long idDrinkType) {
		return drinkTypeRepository.findById(idDrinkType).get();
	}
	
	public DrinkType findByName (String DrinkType) {
		return drinkTypeRepository.findByDrinkTypeIgnoreCase(DrinkType);
	}
	
	public DrinkType save (DrinkType drinkType) {
		return drinkTypeRepository.save(drinkType);
	}
	
	public DrinkType delete (Long idDrinkType) {
		DrinkType drinkType = findById(idDrinkType);
		//TODO tratar erro
		drinkTypeRepository.delete(drinkType);
		return drinkType;
	}
}
