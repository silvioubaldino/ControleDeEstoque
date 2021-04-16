package com.ControleDeEstoque.drink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ControleDeEstoque.drink.DTO.DrinkDTO;
import com.ControleDeEstoque.drink.exception.DrinkException;
import com.ControleDeEstoque.drink.service.DrinkService;
import com.ControleDeEstoque.model.entity.drink.Drink;

@RestController
@RequestMapping("/drink")
public class DrinkController {

	@Autowired
	DrinkService drinkService;

	@GetMapping
	public List<Drink> findAll() {
		List<Drink> drinkList = drinkService.findAll();
		if (drinkList.size() == 0) {
			throw new DrinkException();
		} else {
			return drinkList;
		}
	}

	@GetMapping("/{idDrink}")
	public Drink findById(@PathVariable Long idDrink) {
		return drinkService.findById(idDrink);
	}

	@GetMapping("/name/{drinkName}")
	public List<Drink> findByName(@PathVariable String drinkName) {
		List<Drink> drinkList = drinkService.findByName(drinkName);
		if (drinkList.size() == 0) {
			throw new DrinkException();
		} else {
			return drinkList;
		}
	}

	@GetMapping("/drinkType/{idDrinkType}")
	public List<Drink> findByDrinkType(@PathVariable Long idDrinkType) {
		List<Drink> drinkList = drinkService.findByDrinkType(idDrinkType);
		if (drinkList.size() == 0) {
			throw new DrinkException();
		} else {
			return drinkList;
		}
	}

	@PostMapping
	public Drink save(@RequestBody DrinkDTO drinkDTO) {
		return drinkService.save(drinkDTO);
	}

	@DeleteMapping("/{idDrink}")
	public Drink delete(@PathVariable Long idDrink) {
		return drinkService.delete(idDrink);
	}
}
