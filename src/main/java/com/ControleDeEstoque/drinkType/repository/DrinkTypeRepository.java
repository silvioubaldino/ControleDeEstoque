package com.ControleDeEstoque.drinkType.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ControleDeEstoque.model.entity.drink_type.DrinkType;

public interface DrinkTypeRepository extends JpaRepository<DrinkType, Long>{
	
	List<DrinkType>findByDrinkTypeContainingIgnoreCase(String DrinkType);
}
