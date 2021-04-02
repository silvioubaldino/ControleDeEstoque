package com.ControleDeEstoque.drinkType.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ControleDeEstoque.drinkType.repository.DrinkTypeRepository;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;

@Service
public class DrinkTypeService {

	@Autowired
	DrinkTypeRepository drinkTypeRepository;
	
	public DrinkType findDrinkTypeById(Long idDrinkType) {
		return drinkTypeRepository.findDrinkTypeByidDrinkType(idDrinkType);
	}
}
