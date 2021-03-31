package com.ControleDeEstoque.drink.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ControleDeEstoque.drink.repository.DrinkRepository;
import com.ControleDeEstoque.model.entity.drink.Drink;

@Service
public class DrinkService {

	@Autowired
	DrinkRepository drinkRepository;
	
	public Iterable<Drink> findAll() {
		return drinkRepository.findAll();
	}
	
	public Optional<Drink> findById(Long idDrink) {
		return drinkRepository.findById(idDrink);
	}
}
