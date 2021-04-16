package com.ControleDeEstoque.drink.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ControleDeEstoque.model.entity.drink.Drink;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

	List<Drink> findBydrinkNameContainingIgnoreCase(String name);
	
	List<Drink> findDrinkByDrinkType(DrinkType drinkType);	
	
}
