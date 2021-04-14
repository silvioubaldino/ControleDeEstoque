package com.ControleDeEstoque.drinkType.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ControleDeEstoque.model.entity.drink_type.DrinkType;

public interface DrinkTypeRepository extends JpaRepository<DrinkType, Long>{
	
	DrinkType findByDrinkTypeIgnoreCase(String DrinkType);
}
