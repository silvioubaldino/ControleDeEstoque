package com.ControleDeEstoque.drinkType.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ControleDeEstoque.drinkType.exception.DrinkTypeException;
import com.ControleDeEstoque.drinkType.repository.DrinkTypeRepository;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;

@Service
public class DrinkTypeService {

	@Autowired
	DrinkTypeRepository drinkTypeRepository;
	
	public List<DrinkType> findAll(){
		return drinkTypeRepository.findAll();
	}
	
	public DrinkType findById(Long idDrinkType) {
		return drinkTypeRepository.findById(idDrinkType).orElseThrow(DrinkTypeException::new);
	}
	
	public List<DrinkType> findByName (String DrinkType) {
		return drinkTypeRepository.findByDrinkTypeContainingIgnoreCase(DrinkType);
	}
	
	public DrinkType save (DrinkType drinkType) {
		return drinkTypeRepository.save(drinkType);
	}
	
	public DrinkType delete (Long idDrinkType) {
		DrinkType drinkType = findById(idDrinkType);
		drinkTypeRepository.delete(findById(idDrinkType));
		return drinkType;
	}
}
